package com.example.scg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScgApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScgApplication.class, args);
	}

//	@Bean
//	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("order-service", p -> p
//						.path("/order/**")
//						.filters(f -> f
//								.rewritePath("/order/(?<remaining>.*)", "/${remaining}")
//								.addRequestHeader("auth", "Y")
//						)
//						.uri("lb://order-service"))
//
//				.route("product-service",p -> p
//						.path("/product/**")
//						.filters(f -> f
//								.rewritePath("/product/(?<remaining>.*)", "/${remaining}")
//								.circuitBreaker(config -> config
//										.setName("productCircuit")
//										.setFallbackUri("forward/:fallback/404") // 서버 내부에서 경로를 넘김
////										.setFallbackUri("redirect:/error") // 아예 다른 url로 요청
//								)
//
//						)
//						.uri("lb://product-service"))
//				.build();
//	}
}
