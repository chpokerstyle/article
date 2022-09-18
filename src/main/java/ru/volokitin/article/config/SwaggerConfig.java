package ru.volokitin.article.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.OAS_30).select()
                .apis(RequestHandlerSelectors.basePackage("ru.volokitin.article.controller")).build();
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(new Info().title("test task")
                .description("description article task").termsOfService("").version("0.0.1")
                .license(new License().name("").url("http://unlicense.org"))
                .contact(new io.swagger.v3.oas.models.info.Contact().email("")));
    }


}
