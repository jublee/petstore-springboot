package org.petstore.demo;

import org.petstore.demo.config.ApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApiProperties.class)
public class Application {

	static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
