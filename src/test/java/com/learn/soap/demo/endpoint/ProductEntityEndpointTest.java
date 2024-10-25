package com.learn.soap.demo.endpoint;

import com.learn.soap.demo.gen.*;
import com.learn.soap.demo.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Mohammed Abdu
 * @version vr0.1
 * @email eng.mo.abdu@gmail.com
 * @creationDate 25 Oct 2024
 */

@ExtendWith(MockitoExtension.class)
@DisplayName("ProductEntity Endpoint Tests")
class ProductEntityEndpointTest {

    @InjectMocks
    private ProductEndpoint productEndpoint;

    @Mock
    private ProductService productService;

    @Test
    void testGetProduct() {
        // Arrange
        GetProductRequest request = new GetProductRequest();
        request.setName("Sample Product"); // Example product ID

        GetProductResponse expectedResponse = new GetProductResponse();
        Product product = new Product();
        product.setId(1);
        product.setName("Sample Product");
        product.setDescription("This is a sample product.");
        product.setPrice(100.0);
        expectedResponse.setProduct(product);

        when(productService.getProduct(request)).thenReturn(expectedResponse);

        // Act
        GetProductResponse actualResponse = productEndpoint.getProduct(request);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(productService, times(1)).getProduct(request);
    }

    @Test
    void testFindProductById() {
        // Arrange
        FindProductByIdRequest request = new FindProductByIdRequest();
        request.setId(1); // Example product ID

        FindProductByIdResponse expectedResponse = new FindProductByIdResponse();
        Product product = new Product();
        product.setId(1);
        product.setName("Sample Product");
        product.setDescription("This is a sample product.");
        product.setPrice(100.0);
        expectedResponse.setProduct(product);

        when(productService.findProductById(request)).thenReturn(expectedResponse);

        // Act
        FindProductByIdResponse actualResponse = productEndpoint.findProductById(request);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(productService, times(1)).findProductById(request);
    }

    @Test
    void testGetProducts() {
        // Arrange
        GetProductsRequest request = new GetProductsRequest();

        GetProductsResponse expectedResponse = new GetProductsResponse();
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Sample Product 1");
        product1.setDescription("This is the first sample product.");
        product1.setPrice(50.0);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Sample Product 2");
        product2.setDescription("This is the second sample product.");
        product2.setPrice(75.0);

        expectedResponse.getProducts().add(product1);
        expectedResponse.getProducts().add(product2);

        when(productService.getProducts(request)).thenReturn(expectedResponse);

        // Act
        GetProductsResponse actualResponse = productEndpoint.getProducts(request);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(productService, times(1)).getProducts(request);
    }

    @Test
    void testPostProducts() {
        // Arrange
        PostProductRequest request = new PostProductRequest();
        Product newProduct = new Product();
        newProduct.setName("New Sample Product");
        newProduct.setDescription("This is a newly created sample product.");
        newProduct.setPrice(120.0);
        request.setProduct(newProduct);

        PostProductResponse expectedResponse = new PostProductResponse();
        expectedResponse.setProduct(newProduct);

        when(productService.postProducts(request)).thenReturn(expectedResponse);

        // Act
        PostProductResponse actualResponse = productEndpoint.postProducts(request);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(productService, times(1)).postProducts(request);
    }
}
