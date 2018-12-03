package com.structure.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DataStructureApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DataStructureApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DataStructureApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}
}