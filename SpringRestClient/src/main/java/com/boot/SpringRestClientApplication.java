package com.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestClientApplication implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(SpringRestClientApplication.class);

	@Override
	public void run(String... args) throws Exception {
		log.info("Iniciando mensaje desde consola...");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRestClientApplication.class, args);
	}
}
