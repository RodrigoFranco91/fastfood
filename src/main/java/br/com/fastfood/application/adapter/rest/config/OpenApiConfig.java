package br.com.fastfood.application.adapter.rest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Documentation - Fastfood")
                        .version("1.0.0")
                        .description("Documentação da API Fasfood - Entrega 1 Fase do Tech Challenge."));
    }
}