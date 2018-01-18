package com.codingdojo.dojosurvey;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class DojosurveyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DojosurveyApplication.class, args);
	}
	@Controller
	public class HomeController {
		@RequestMapping("/")
	    public String index() {
	        return "index.jsp";
	    }
	    @RequestMapping("/result")
	    public String result(HttpSession session) {
	    		return "result.jsp";
	    }
		@RequestMapping(path="/submit", method=RequestMethod.POST)
	    public String login(HttpSession session, @RequestParam(value="name") String username, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment) {
			session.setAttribute("username", username);
			session.setAttribute("location", location);
			session.setAttribute("language", language);
			session.setAttribute("comment", comment);
			return "redirect:/result";
	    }
	}
}
