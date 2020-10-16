package com.walnutit.composite_pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CompositePatternApplication {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CompositePatternApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CompositePatternApplication.class,
				args);
		
		Client client = new Client();
		client.startClient();
		LOGGER.info(client.toString());
	}
}
