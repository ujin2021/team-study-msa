package com.example.order;

import org.springframework.web.service.annotation.GetExchange;

public interface OrderClient {
    @GetExchange("http://product-service/hello")
    String getProductSayHello();
}
