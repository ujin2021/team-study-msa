package com.example.product.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cart")
public record Cart (
    @Id
    String id,
    String name,
    @DBRef
    List<Product> products
){
    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void remoteProduct(Product product) {
        this.products.remove(product);
    }
}