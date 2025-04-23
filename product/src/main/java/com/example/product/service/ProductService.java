package com.example.product.service;

import com.example.product.domain.Product;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String productId) {
        return productRepository.findById(productId).get();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(String productId) {
        productRepository.deleteById(productId);
    }
}
