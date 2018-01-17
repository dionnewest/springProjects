package com.codingdojo.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}
	@RestController
	@RequestMapping("/")
	public class GreetingController {
	    @RequestMapping("")
	    public String index(@RequestParam(value="name", required=false) String name){
	    		if(name == null) {
	    			return "Hello Human!";
	    		} else {
	    			return "Hello " + name;
	    		}
	    }
	    
	    @RequestMapping("/hello")
	    public String hello(){
	      return "Hello world! What route did you use to access me?";
	    }
	    @RequestMapping("/goodbye")
	    public String world(){
	      return "Goodbye world!";
	    }
	}
}
