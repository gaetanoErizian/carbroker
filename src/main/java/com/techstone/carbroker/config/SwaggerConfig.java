package com.techstone.carbroker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("CarBroker")
                        .description("Applicazione per caricamento auto da csv, filtrare ed ottenere le occorrenze inserite")
                        .version("1.0"));
    }
}