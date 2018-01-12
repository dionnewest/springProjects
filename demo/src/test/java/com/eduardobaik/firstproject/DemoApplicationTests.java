package com.eduardobaik.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class DemoApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplicationTests.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "Hello World";
	}
}
