package com.example.product.controller;

import com.example.product.domain.Product;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productSampleService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.ok(productSampleService.findAll());
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> findProductById(@PathVariable String productId) {
        return ResponseEntity.ok(productSampleService.findById(productId));
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProductById(@PathVariable String productId) {
        productSampleService.deleteProductById(productId);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productSampleService.createProduct(product));
    }
}
