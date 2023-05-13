package com.paradigmadigital.technicaltest.infrastructure.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerDocumentationConfig {

  @Bean
  public OpenAPI openApi() {
    return new OpenAPI()
        .info(new Info()
            .title("Paradigma Digital Technical Test")
            .description(
                "API designed for the technical test for Paradigma Digital's hiring process")
            .termsOfService("")
            .version("1.0.0")
            .license(new License()
                .name("")
                .url("http://unlicense.org"))
            .contact(new io.swagger.v3.oas.models.info.Contact()
                .email("")));
  }

}
