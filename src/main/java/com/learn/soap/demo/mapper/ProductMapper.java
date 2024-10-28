package com.learn.soap.demo.mapper;

import com.learn.soap.demo.entity.ProductEntity;
import com.learn.soap.demo.products.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mohammed Abdu
 * @version vr0.1
 * @email eng.mo.abdu@gmail.com
 * @creationDate 25 Oct 2024
 */

@Component
public class ProductMapper {

    public ProductEntity convertProductToProductModel(Product product) {
        ProductEntity productEntityModel = new ProductEntity();
        productEntityModel.setId(product.getId());
        productEntityModel.setName(product.getName());
        productEntityModel.setPrice(product.getPrice());
        productEntityModel.setDescription(product.getDescription());
        return productEntityModel;
    }

    public Product convertProductModelToProduct(ProductEntity productEntityModel) {
        Product product = new Product();
        product.setId(productEntityModel.getId());
        product.setName(productEntityModel.getName());
        product.setPrice(productEntityModel.getPrice());
        product.setDescription(productEntityModel.getDescription());
        return product;
    }

    public List<ProductEntity> convertProductsToProductModels(List<Product> products) {
        List<ProductEntity> productEntityModels = new ArrayList<>();
        for (Product product : products) {
            productEntityModels.add(convertProductToProductModel(product));
        }
        return productEntityModels;
    }

    public List<Product> convertProductModelsToProducts(List<ProductEntity> productEntityModels) {
        List<Product> products = new ArrayList<>();
        for (ProductEntity productEntity : productEntityModels) {
            products.add(convertProductModelToProduct(productEntity));
        }
        return products;
    }
}
