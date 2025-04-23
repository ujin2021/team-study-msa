package com.example.product.controller;

import com.example.product.domain.Cart;
import com.example.product.domain.Product;
import com.example.product.service.CartService;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/cart"))
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> findAllProducts(@PathVariable String cartId) {
        return ResponseEntity.of(cartService.findById(cartId));
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.createCart(cart));
    }
}
