package com.example.product.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public record Product (
    @Id
    String id,
    String name,
    int price,
    String description,
    String imgUrl,
    ProductDetail productDetail
){}