package com.ciandt.entregas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication // Mesmo que @Configuration @EnableAutoConfiguration @ComponentScan
public class EntregasApiAplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(EntregasApiAplication.class, args);
	}
}