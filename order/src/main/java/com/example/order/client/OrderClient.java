package com.example.order.client;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("http://product-service/")
public interface OrderClient {
    @GetExchange("hello")
    String getProductSayHello();
}
