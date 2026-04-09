package com.ejemplo.demo.metadata;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerMetadata {
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Workshop Spring Boot")
                        .version("2.6.0")
                        .description("UMG Workshop")
                        .contact(new Contact()
                                .name("Estalin Alejandro Godoy Campos, 0905-24-5051")
                                .email("egodoyc4@umg.edu.gt")));
    }
}
