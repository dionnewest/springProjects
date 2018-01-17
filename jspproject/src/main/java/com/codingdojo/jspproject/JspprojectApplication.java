package com.codingdojo.jspproject;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class JspprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JspprojectApplication.class, args);
	}
	
	@Controller
	@RequestMapping("/yourserver")
	public class HomeController {
	    @RequestMapping("")
	    public String index() {
	        return "index.jsp";
	    }
	    @RequestMapping("/date")
	    public String date(Model model) {
	    		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, yyyy");
	    		Date date = new Date();
	    		model.addAttribute("date", dateFormat.format(date));
	        return "date.jsp";
	    }
	    @RequestMapping("/time") 
	    public String time(Model model) {
		    	SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
	    		Date time = new Date();
	    		model.addAttribute("time", timeFormat.format(time));
	        return "timeDisplay.jsp";
	    }
	}
}
