package com.technicaltest.test.context;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.technicaltest.test.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Technical Test Java Developer",
                "API REST.",
                "v1",
                "Terms of service",
                new Contact("SACAViX Tech", "www.linkedin.com/in/oscar-sanchez1993", "oscar100493@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

}
