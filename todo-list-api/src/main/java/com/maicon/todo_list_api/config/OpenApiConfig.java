package com.maicon.todo_list_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info()
                        .title("To-do List API")
                        .description("API de listas de tarefas colabortivas")
                        .version("1.0.0")
                );
    }
}
