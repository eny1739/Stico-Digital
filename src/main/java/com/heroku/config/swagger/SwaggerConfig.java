package com.heroku.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title("Stico Digital")
                .description("Dokumentasi API for developers")
                .termsOfServiceUrl("http://https://github.com/eny1739")
                .contact(getContact()).license("eny sulistyowati License")
                .licenseUrl("enysulistyowati336@gmail.com").version("1.0.0").build();
    }

    private Contact getContact() {
        return new Contact("Eny Sulistyowati", "http://https://github.com/eny1739", "enysulistyowati336@gmail.com");
    }
}
