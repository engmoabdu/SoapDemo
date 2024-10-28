package com.learn.soap.demo.endpoint;

import com.learn.soap.demo.products.*;
import com.learn.soap.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static com.learn.soap.demo.utils.Constants.NAMESPACE_URI;

/**
 * @author Mohammed Abdu
 * @version vr0.1
 * @email eng.mo.abdu@gmail.com
 * @creationDate 25 Oct 2024
 */
@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {

    private final ProductService productService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProduct(@RequestPayload GetProductRequest request) {
        return productService.getProduct(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "findProductByIdRequest")
    @ResponsePayload
    public FindProductByIdResponse findProductById(@RequestPayload FindProductByIdRequest request) {
        return productService.findProductById(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getProducts(@RequestPayload GetProductsRequest request) {
        return productService.getProducts(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postProductRequest")
    @ResponsePayload
    public PostProductResponse postProducts(@RequestPayload PostProductRequest request) {
        return productService.postProducts(request);
    }
}
