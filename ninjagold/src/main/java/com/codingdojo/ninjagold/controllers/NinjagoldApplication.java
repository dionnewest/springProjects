package com.codingdojo.ninjagold.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NinjagoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(NinjagoldApplication.class, args);
	}

}
