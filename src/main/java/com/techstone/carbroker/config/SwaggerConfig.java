package com.techstone.carbroker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)  // Usa OpenAPI 3
                .select()
                .apis(RequestHandlerSelectors.any())  // Puoi filtrare i pacchetti qui per una selezione più specifica
                .paths(PathSelectors.any())  // Analogamente, puoi filtrare i percorsi specifici
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfo(
                "CarBroker", // titolo
                "Applicazione per caricamento auto da csv", // descrizione
                "v1", // versione
                "Applicazione di test per selezione",
                new Contact("Gaetano Erizian", "il tuo sito web", "gaetano.erizian@gmail.com"), // informazioni di contatto
                "Licenza Open",
                "URL licenza (nessuna)",
                Collections.emptyList() // estensioni
        );
    }
}