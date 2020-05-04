package com.fnb.cis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.fnb.cis")
public class CisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CisApplication.class, args);
	}

}
