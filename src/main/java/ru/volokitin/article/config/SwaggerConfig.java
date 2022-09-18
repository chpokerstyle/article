package ru.volokitin.article.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;



@Configuration
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //Заголовок страницы
                .title("Article")
                // основатель
                .contact(new Contact("Волокитин Дмитрий", "http://www.hochu-kushat.com", "zoldaten48@gmail.com"))
                //Описание
                .description("Простой и элегантный стиль Restful")
                .termsOfServiceUrl("http://blog.csdn.net/canfengli")
                //номер версии
                .version("1.0")
                .build();
    }

        @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.volokitin.article.controller")) // Пакет сканирования Swagger
                .paths(PathSelectors.any())
                .build();
    }



//        @Bean
//    public OpenAPI openApi() {
//        return new OpenAPI().info(new Info().title("test task")
//                .description("description article task").termsOfService("").version("0.0.1")
//                .license(new License().name("").url("http://unlicense.org"))
//                .contact(new io.swagger.v3.oas.models.info.Contact().email("")));
//    }


}
