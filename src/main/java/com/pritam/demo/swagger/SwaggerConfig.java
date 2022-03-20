package com.pritam.demo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// https://dzone.com/articles/simplified-spring-swagger
// https://dzone.com/articles/spring-boot-restful-api-documentation-with-swagger
// https://stackoverflow.com/questions/45766296/spring-boot-swagger-ui-protect-ui-access/45767928

// http://localhost:8080/swagger-ui.html
// http://localhost:8080/v2/api-docs

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build(); //.apiInfo(metadata());
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("Springboot CRUD").description("Swagger").version("1.0").build();
	}

}