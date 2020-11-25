package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EShopingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShopingApplication.class, args);
	}

}
