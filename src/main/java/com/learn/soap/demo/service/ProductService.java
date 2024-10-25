package com.learn.soap.demo.service;

import com.learn.soap.demo.gen.*;

/**
 * @author Mohammed Abdu
 * @version vr0.1
 * @email eng.mo.abdu@gmail.com
 * @creationDate 25 Oct 2024
 */
public interface ProductService {

    GetProductResponse getProduct(GetProductRequest request);

    FindProductByIdResponse findProductById(FindProductByIdRequest request);

    GetProductsResponse getProducts(GetProductsRequest request);

    PostProductResponse postProducts(PostProductRequest request);
}
