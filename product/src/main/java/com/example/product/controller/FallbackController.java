package com.example.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
    @RequestMapping("/404")
    public ResponseEntity<String> handleFallback404() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("요청하신 페이지를 찾을 수 없습니다.");
    }
}
