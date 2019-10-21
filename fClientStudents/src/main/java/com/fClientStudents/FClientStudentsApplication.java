package com.fClientStudents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FClientStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FClientStudentsApplication.class, args);
	}

}
