package com.covid19api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Covid19ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19ApiApplication.class, args);
	}

	@Bean
	public Docket demoApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.any())
	            .paths(Predicates.not(PathSelectors.regex("/error.*")))
	            .build();
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/covid19/healthcheck").allowedOrigins("*").allowedHeaders("*");
				registry.addMapping("/covid19/healthcheck").allowedOrigins("http://localhost:4200").allowedHeaders("*");
			}
		};
	}
}
