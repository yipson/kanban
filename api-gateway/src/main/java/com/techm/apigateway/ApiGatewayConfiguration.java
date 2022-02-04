package com.techm.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){

        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeaderRequest", "valueRequest")
                                .addResponseHeader("MyHeaderResponse", "valueResponse")
                                .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))

                .route(p -> p.path("/board/**")
                        .uri("lb://board-service"))

                .route(p -> p.path("/task/**")
                        .uri("lb://tasks-service"))

                .route(p -> p
                        .path("/user/**")
                        .filters(f -> f
//                                .addRequestHeader("Authorization", TOKEN)
//                                .addResponseHeader("Authorization", TOKEN)
                                .addRequestHeader("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5IiwiaWF0IjoxNjQzOTkzMzc4LCJzdWIiOiJzYW50aWFnb0BtYWlsLmNvbSIsImlzcyI6Ik1haW4iLCJleHAiOjE2NDQ1OTgxNzh9.6MZCZT3mLbYcuaeUiOsDGym6lanqo7vTy03XANGGPwM")
                                .addResponseHeader("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5IiwiaWF0IjoxNjQzOTkzMzc4LCJzdWIiOiJzYW50aWFnb0BtYWlsLmNvbSIsImlzcyI6Ik1haW4iLCJleHAiOjE2NDQ1OTgxNzh9.6MZCZT3mLbYcuaeUiOsDGym6lanqo7vTy03XANGGPwM"))
                        .uri("lb://users-service"))
//                .route(p -> p
//                        .path("/login")
//                        .uri("lb://users-service/login"))

                .build();
    }

}
