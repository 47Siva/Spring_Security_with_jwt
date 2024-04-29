package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Authentication APIS",version = "1.0",description = "Authentication Management Apis."))
public class SpringSecurityDemo2WithJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemo2WithJwtApplication.class, args);
	}

}
