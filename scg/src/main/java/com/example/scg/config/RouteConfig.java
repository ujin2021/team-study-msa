package com.example.scg.config;

import com.example.scg.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RouteConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-service", r -> r
                        .path("/order/**")
                        .filters(f -> f
                                .filter(jwtAuthenticationFilter)
                                .rewritePath("/order/(?<remaining>.*)", "/${remaining}")
                        ) // 커스텀 JWT 필터 적용
                        .uri("lb://order-service"))
                .route("product-service", r -> r.path("/product/**")
                        .filters(f -> f
                                .filter(jwtAuthenticationFilter)
                                .rewritePath("/product/(?<remaining>.*)", "/${remaining}")
                        )
                        .uri("lb://product-service"))
                .build();
    }
}
