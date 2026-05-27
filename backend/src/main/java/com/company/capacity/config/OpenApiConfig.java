package com.company.capacity.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Capacity Planning Tool API")
                        .version("1.0.0")
                        .description("Strategic capacity planning — initiative & epic level")
                        .contact(new Contact().name("Engineering Leadership")));
    }
}
