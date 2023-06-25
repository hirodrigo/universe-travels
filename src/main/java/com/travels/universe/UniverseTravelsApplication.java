package com.travels.universe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UniverseTravelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniverseTravelsApplication.class, args);
	}

}
