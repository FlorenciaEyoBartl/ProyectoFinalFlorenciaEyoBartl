package com.fleb.evta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.validation.annotation.Validated;

@Validated
@SpringBootApplication

@EntityScan(basePackages = "com.fleb.evta.model")

public class EvtaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvtaApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
