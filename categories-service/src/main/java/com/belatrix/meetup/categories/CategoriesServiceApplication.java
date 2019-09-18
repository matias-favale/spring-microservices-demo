package com.belatrix.meetup.categories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CategoriesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoriesServiceApplication.class, args);
	}

}
