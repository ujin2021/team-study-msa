package com.example.order.config;

import com.example.order.client.OrderClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Bean
    @LoadBalanced
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }


    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return  builder.build();
    }

    @Bean
    public HttpServiceProxyFactory factory(RestClient restClient) {
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        return HttpServiceProxyFactory.builderFor(adapter).build();
    }

    @Bean
    public OrderClient orderClient(HttpServiceProxyFactory factory) {
        return factory.createClient(OrderClient.class);
    }
}