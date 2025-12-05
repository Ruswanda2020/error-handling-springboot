package com.onedev.service;

import com.onedev.exception.ResourceNotFoundException;
import com.onedev.model.Product;
import com.onedev.payload.ProductRequest;
import com.onedev.payload.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private Map<String, Product> products = new HashMap<>();

    public ProductServiceImpl() {
        products.put("1", new Product("1", "Laptop", 1200.00));
        products.put("2", new Product("2", "Mouse", 25.00));
    }

    @Override
    public ProductResponse getProductById(String id) {
        Product product = products.get(id);
        if (product == null) {
            throw new ResourceNotFoundException("Product with ID " + id + " not found");
        }
        return new ProductResponse(product.getId(), product.getName(), product.getPrice());
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        String newId = String.valueOf(products.size() + 1);
        Product newProduct = new Product(newId, productRequest.getName(), productRequest.getPrice());
        products.put(newId, newProduct);
        return new ProductResponse(newProduct.getId(), newProduct.getName(), newProduct.getPrice());
    }
}
