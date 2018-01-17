package com.codingdojo.sessionpractice;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class SessionpracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionpracticeApplication.class, args);
	}
	@Controller
	public static class HomeController {
		public static Integer count = 0;
	    @RequestMapping("/")
	    public String index(HttpSession session) {
	    	count += 1;
	    	if (session.getAttribute("counter") == null) {
	    		session.setAttribute("counter", count);
	    	} else {
	    		session.setAttribute("counter", count);
	    	}
	    	count = (Integer) session.getAttribute("counter");
//	    public String index() {
//	    	count += 1;
	    	return "index.jsp";
	    }
	    @RequestMapping("/counter")
	    public String counter(Model model) {
	    		model.addAttribute("count", count);
	        return "counter.jsp";
	    }
	}
	
}
