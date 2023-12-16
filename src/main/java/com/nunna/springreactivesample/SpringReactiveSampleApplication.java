package com.nunna.springreactivesample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@EnableAutoConfiguration
@ComponentScan(basePackages = "com")
public class SpringReactiveSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveSampleApplication.class, args);
	}

}
