package com.ms.ecom.order.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI orderServiceAPI(){
        return new OpenAPI()
                .info(new Info().title("Order Service API")
                        .description("Order Service API for E-Commerce Application")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0")));
    }
}
