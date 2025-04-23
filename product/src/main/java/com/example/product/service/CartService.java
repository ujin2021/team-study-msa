package com.example.product.service;

import com.example.product.domain.Cart;
import com.example.product.domain.Product;
import com.example.product.repository.CartRepository;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Optional<Cart> findById(String cartId) {
        return cartRepository.findById(cartId);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }
}
