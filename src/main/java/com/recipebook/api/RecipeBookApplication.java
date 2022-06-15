
package com.recipebook.api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main SpringBootApplication class with some customizations for OpenAPI.
 */
@SpringBootApplication
public class RecipeBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeBookApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info().title("RecipeBook application API")
                .version("1.0.1-SNAPSHOT")
                .description("-- > Demo application < --"));
    }
}
