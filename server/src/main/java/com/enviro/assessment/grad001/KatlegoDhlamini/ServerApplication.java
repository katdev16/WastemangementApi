package com.enviro.assessment.grad001.KatlegoDhlamini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Waste Management API", version = "1.0", description = "API for managing waste categories, disposal guidelines, and recycling tips"))
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
