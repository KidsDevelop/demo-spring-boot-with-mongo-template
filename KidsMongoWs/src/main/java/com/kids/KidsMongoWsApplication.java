package com.kids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.kids")
@SpringBootApplication
public class KidsMongoWsApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KidsMongoWsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(KidsMongoWsApplication.class, args);
	}
}
