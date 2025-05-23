package com.example.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

@RestController
@RequiredArgsConstructor
public class ProductSampleController {

    @GetExchange("/hello")
    public ResponseEntity<String> sampleapi() {
        return new ResponseEntity<>("Hello World. This is product", HttpStatus.OK);
    }
}
