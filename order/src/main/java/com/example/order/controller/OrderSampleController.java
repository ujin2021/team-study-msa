package com.example.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequiredArgsConstructor
public class OrderSampleController {
    private final RestClient restClient;

    @GetMapping("/hello")
    public ResponseEntity<String> sampleapi() {
        return new ResponseEntity<>("Hello World. This is order", HttpStatus.OK);
    }

    @GetMapping("/productorder")
    public ResponseEntity<String> callProduct() {
        String productMessage = restClient.get()
                .uri("http://product-service/hello")
                .retrieve()
                .body(String.class);

        return new ResponseEntity<>("From product : " + productMessage, HttpStatus.OK);
    }
}
