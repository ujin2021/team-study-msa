package com.example.product.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public record ProductDetail (
    @Id
    String id,
    int like,
    List<String> review,
    String content
){}
