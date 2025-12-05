package com.onedev.controller;

import com.onedev.payload.ProductRequest;
import com.onedev.payload.ProductResponse;
import com.onedev.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse newProduct = productService.createProduct(productRequest);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ProductResponse> getProductById(@RequestParam String id) {
        ProductResponse product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/error")
    public ResponseEntity<String> triggerGenericError() {
        throw new RuntimeException("This is a generic error triggered by the controller.");
    }
}
