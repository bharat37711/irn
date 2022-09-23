package com.irn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ErpApplication {

	public static void main(String[] args) {

		SpringApplication.run(ErpApplication.class, args);

	}

	@Bean
	public RestTemplate template() {

		return new RestTemplate();
	}

}
