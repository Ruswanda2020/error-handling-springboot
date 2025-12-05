package com.onedev.service;

import com.onedev.payload.ProductRequest;
import com.onedev.payload.ProductResponse;

public interface ProductService {
    ProductResponse getProductById(String id);
    ProductResponse createProduct(ProductRequest productRequest);
}
