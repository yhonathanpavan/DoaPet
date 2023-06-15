package com.tcc.doapet.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("DoaPet - API")
                        .version("v1.0.0")
                        .description("DoaPet: API desenvolvida em Java com objetivo de fornecer uma plataforma de doações para causas animais.")
                ).externalDocs(new ExternalDocumentation()
                        .description("Source Code")
                        .url("https://github.com/yhonathanpavan/DoaPet"));
    }
}