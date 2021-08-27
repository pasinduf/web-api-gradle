package com.webapi.main.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing(auditorAwareRef = "auditorAware")
public class ApplicationService {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationService.class, args);
	}
}
