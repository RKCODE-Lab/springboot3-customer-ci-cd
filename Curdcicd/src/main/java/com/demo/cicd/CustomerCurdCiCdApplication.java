package com.demo.cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CustomerCurdCiCdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerCurdCiCdApplication.class, args);
	}

}
