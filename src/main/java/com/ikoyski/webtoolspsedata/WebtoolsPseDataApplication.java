package com.ikoyski.webtoolspsedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WebtoolsPseDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebtoolsPseDataApplication.class, args);
	}

}
