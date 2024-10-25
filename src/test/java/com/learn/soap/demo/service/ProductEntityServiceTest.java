package com.learn.soap.demo.service;

import com.learn.soap.demo.entity.ProductEntity;
import com.learn.soap.demo.gen.*;
import com.learn.soap.demo.service.impl.ProductServiceImpl;
import com.learn.soap.demo.repository.ProductRepository;
import com.learn.soap.demo.mapper.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import jakarta.persistence.EntityNotFoundException;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Mohammed Abdu
 * @version vr0.1
 * @email eng.mo.abdu@gmail.com
 * @creationDate 25 Oct 2024
 */

@ExtendWith(MockitoExtension.class)
@DisplayName("ProductEntity Service Tests")
class ProductEntityServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    private PostProductRequest postProductRequest;
    private PostProductResponse expectedPostResponse;
    private ProductEntity productEntity;
    private GetProductRequest getProductRequest;
    private GetProductResponse expectedGetResponse;
    private FindProductByIdRequest findProductByIdRequest;
    private FindProductByIdResponse expectedFindResponse;
    private GetProductsRequest getProductsRequest;
    private GetProductsResponse expectedGetProductsResponse;

    @BeforeEach
    void init() {
        // Initialize PostProductRequest
        postProductRequest = new PostProductRequest();
        Product productToPost = new Product();
        productToPost.setId(1);
        productToPost.setName("Test Product");
        productToPost.setPrice(10.0);
        productToPost.setDescription("Test Description");
        postProductRequest.setProduct(productToPost);

        // Initialize PostProductResponse
        expectedPostResponse = new PostProductResponse();
        expectedPostResponse.setProduct(productToPost);

        // Initialize ProductEntity
        productEntity = new ProductEntity();
        productEntity.setId(1);
        productEntity.setName("Test Product");
        productEntity.setPrice(10.0);
        productEntity.setDescription("Test Description");

        // Initialize GetProductRequest and Response
        getProductRequest = new GetProductRequest();
        getProductRequest.setName("Test Product");

        expectedGetResponse = new GetProductResponse();
        expectedGetResponse.setProduct(productToPost);

        // Initialize FindProductByIdRequest and Response
        findProductByIdRequest = new FindProductByIdRequest();
        findProductByIdRequest.setId(1);

        expectedFindResponse = new FindProductByIdResponse();
        expectedFindResponse.setProduct(productToPost);

        // Initialize GetProductsRequest and Response
        getProductsRequest = new GetProductsRequest();
        expectedGetProductsResponse = new GetProductsResponse();
        expectedGetProductsResponse.getProducts().add(productToPost);
    }

    @Test
    @DisplayName("Post Products - Successful")
    void postProducts_shouldReturnResponse() {
        // Arrange
        when(productMapper.convertProductToProductModel(any(Product.class))).thenReturn(productEntity);
        when(productRepository.save(any(ProductEntity.class))).thenReturn(productEntity);
        when(productMapper.convertProductModelToProduct(any(ProductEntity.class))).thenReturn(postProductRequest.getProduct());

        // Act
        PostProductResponse response = productService.postProducts(postProductRequest);

        // Assert
        assertEquals(expectedPostResponse.getProduct().getName(), response.getProduct().getName());
        verify(productMapper, times(1)).convertProductToProductModel(any(Product.class));
        verify(productRepository, times(1)).save(any(ProductEntity.class));
        verify(productMapper, times(1)).convertProductModelToProduct(any(ProductEntity.class));
    }

    @Test
    @DisplayName("Get Product - Successful")
    void getProduct_shouldReturnResponse() {
        // Arrange
        when(productRepository.findByName(getProductRequest.getName())).thenReturn(productEntity);
        when(productMapper.convertProductModelToProduct(any(ProductEntity.class))).thenReturn(postProductRequest.getProduct());

        // Act
        GetProductResponse response = productService.getProduct(getProductRequest);

        // Assert
        assertEquals(expectedGetResponse.getProduct().getName(), response.getProduct().getName());
        verify(productRepository, times(1)).findByName(getProductRequest.getName());
        verify(productMapper, times(1)).convertProductModelToProduct(any(ProductEntity.class));
    }

    @Test
    @DisplayName("Find Product By ID - Successful")
    void findProductById_shouldReturnResponse() {
        // Arrange
        when(productRepository.findById(findProductByIdRequest.getId())).thenReturn(Optional.of(productEntity));
        when(productMapper.convertProductModelToProduct(any(ProductEntity.class))).thenReturn(postProductRequest.getProduct());

        // Act
        FindProductByIdResponse response = productService.findProductById(findProductByIdRequest);

        // Assert
        assertEquals(expectedFindResponse.getProduct().getId(), response.getProduct().getId());
        verify(productRepository, times(1)).findById(findProductByIdRequest.getId());
        verify(productMapper, times(1)).convertProductModelToProduct(any(ProductEntity.class));
    }

    @Test
    @DisplayName("Find Product By ID - Not Found")
    void findProductById_shouldThrowException() {
        // Arrange
        when(productRepository.findById(findProductByIdRequest.getId())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> productService.findProductById(findProductByIdRequest));
        verify(productRepository, times(1)).findById(findProductByIdRequest.getId());
    }

    @Test
    @DisplayName("Get Products - Successful")
    void getProducts_shouldReturnResponse() {
        // Arrange
        List<ProductEntity> productEntities = new ArrayList<>();
        productEntities.add(productEntity);
        when(productRepository.findAll()).thenReturn(productEntities);
        when(productMapper.convertProductModelsToProducts(any(List.class))).thenReturn(expectedGetProductsResponse.getProducts());

        // Act
        GetProductsResponse response = productService.getProducts(getProductsRequest);

        // Assert
        assertEquals(expectedGetProductsResponse.getProducts().size(), response.getProducts().size());
        verify(productRepository, times(1)).findAll();
        verify(productMapper, times(1)).convertProductModelsToProducts(any(List.class));
    }
}
