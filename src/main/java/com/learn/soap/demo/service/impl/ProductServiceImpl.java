package com.learn.soap.demo.service.impl;

import com.learn.soap.demo.entity.ProductEntity;
import com.learn.soap.demo.products.*;
import com.learn.soap.demo.mapper.ProductMapper;
import com.learn.soap.demo.repository.ProductRepository;
import com.learn.soap.demo.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mohammed Abdu
 * @version vr0.1
 * @email eng.mo.abdu@gmail.com
 * @creationDate 25 Oct 2024
 */

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productConverter;

    public GetProductResponse getProduct(GetProductRequest request) {
        GetProductResponse response = new GetProductResponse();
        ProductEntity productEntity = productRepository.findByName(request.getName());
        response.setProduct(productConverter.convertProductModelToProduct(productEntity));
        return response;
    }

    public FindProductByIdResponse findProductById(FindProductByIdRequest request) {
        FindProductByIdResponse response = new FindProductByIdResponse();
        ProductEntity productEntity = productRepository.findById(request.getId())
                .orElseThrow(() -> new EntityNotFoundException("ProductEntity not found with ID: " + request.getId()));
        response.setProduct(productConverter.convertProductModelToProduct(productEntity));
        return response;
    }

    public GetProductsResponse getProducts(GetProductsRequest request) {
        GetProductsResponse response = new GetProductsResponse();
        List<ProductEntity> productEntityModels = productRepository.findAll();
        List<com.learn.soap.demo.products.Product> products = productConverter.convertProductModelsToProducts(productEntityModels);
        response.getProducts().addAll(products);
        return response;
    }

    public PostProductResponse postProducts(PostProductRequest request) {
        PostProductResponse response = new PostProductResponse();
        ProductEntity productEntityModel = productConverter.convertProductToProductModel(request.getProduct());
        com.learn.soap.demo.products.Product product = productConverter.convertProductModelToProduct(productRepository.save(productEntityModel));
        response.setProduct(product);
        return response;
    }
}
