package com.example.TodoHW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.TodoHW")
@EntityScan(basePackages = "com.example.TodoHW.model")
@EnableJpaRepositories
public class TodoHwApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoHwApplication.class, args);
	}

}
