package com.techm.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;


@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){

//        String TOKEN = HttpHeaders.AUTHORIZATION;

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
                                .addRequestHeader("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4IiwiaWF0IjoxNjQ0MDA3MDg0LCJzdWIiOiJqYW1lc0BtYWlsLmNvbSIsImlzcyI6Ik1haW4iLCJleHAiOjE2NDQ2MTE4ODR9.rBzUIkinwhI52Q-ERkjDLhsOIY52hsIrJ12Pzajc7l8")
                                .addResponseHeader("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4IiwiaWF0IjoxNjQ0MDA3MDg0LCJzdWIiOiJqYW1lc0BtYWlsLmNvbSIsImlzcyI6Ik1haW4iLCJleHAiOjE2NDQ2MTE4ODR9.rBzUIkinwhI52Q-ERkjDLhsOIY52hsIrJ12Pzajc7l8"))
                        .uri("lb://users-service"))
                .route(p -> p
                        .path("/login")
                        .uri("lb://users-service/login"))

                .route(p -> p
                        .path("/register")
                        .uri("lb://users-service/user/register"))
                .build();
    }

}
