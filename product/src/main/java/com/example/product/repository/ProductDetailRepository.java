package com.example.product.repository;

import com.example.product.domain.Cart;
import com.example.product.domain.ProductDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends MongoRepository<ProductDetail, String> {
}