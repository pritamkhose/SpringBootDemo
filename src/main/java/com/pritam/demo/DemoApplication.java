package com.pritam.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class DemoApplication {

	private static final Logger LOGGER = LogManager.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Sample Info level log message");
		LOGGER.debug("Sample Debug level log message");
		LOGGER.error("Sample Error level log message");
		LOGGER.info("Server started here -->> " + (new Date()));
		
		SpringApplication.run(DemoApplication.class, args);
	}

}
