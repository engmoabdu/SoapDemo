package com.learn.soap.demo.mapper;

import com.learn.soap.demo.entity.ProductEntity;
import com.learn.soap.demo.gen.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Mohammed Abdu
 * @version vr0.1
 * @email eng.mo.abdu@gmail.com
 * @creationDate 25 Oct 2024
 */
@ExtendWith(MockitoExtension.class)
class ProductMapperTest {

    @InjectMocks
    private ProductMapper productMapper;

    private Product product;
    private ProductEntity productEntity;

    @BeforeEach
    void setUp() {
        // Initialize a Product instance
        product = new Product();
        product.setId(1);
        product.setName("Test Product");
        product.setPrice(99.99);
        product.setDescription("Test Description");

        // Initialize a ProductEntity instance
        productEntity = new ProductEntity();
        productEntity.setId(1);
        productEntity.setName("Test Product");
        productEntity.setPrice(99.99);
        productEntity.setDescription("Test Description");
    }

    @Test
    void testConvertProductToProductModel() {
        ProductEntity result = productMapper.convertProductToProductModel(product);
        assertEquals(product.getId(), result.getId());
        assertEquals(product.getName(), result.getName());
        assertEquals(product.getPrice(), result.getPrice());
        assertEquals(product.getDescription(), result.getDescription());
    }

    @Test
    void testConvertProductModelToProduct() {
        Product result = productMapper.convertProductModelToProduct(productEntity);
        assertEquals(productEntity.getId(), result.getId());
        assertEquals(productEntity.getName(), result.getName());
        assertEquals(productEntity.getPrice(), result.getPrice());
        assertEquals(productEntity.getDescription(), result.getDescription());
    }

    @Test
    void testConvertProductsToProductModels() {
        List<Product> products = new ArrayList<>();
        products.add(product);

        List<ProductEntity> result = productMapper.convertProductsToProductModels(products);
        assertEquals(1, result.size());
        assertEquals(product.getId(), result.get(0).getId());
    }

    @Test
    void testConvertProductModelsToProducts() {
        List<ProductEntity> productEntities = new ArrayList<>();
        productEntities.add(productEntity);

        List<Product> result = productMapper.convertProductModelsToProducts(productEntities);
        assertEquals(1, result.size());
        assertEquals(productEntity.getId(), result.get(0).getId());
    }
}