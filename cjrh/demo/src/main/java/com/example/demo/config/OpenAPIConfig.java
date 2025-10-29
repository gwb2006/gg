package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("企业协作平台API文档")
                        .version("1.0.0")
                        .description("提供企业、部门、项目管理等功能的API接口文档")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}