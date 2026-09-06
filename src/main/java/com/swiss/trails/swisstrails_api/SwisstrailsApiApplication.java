package com.swiss.trails.swisstrails_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan 
public class SwisstrailsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwisstrailsApiApplication.class, args);
	}

}
