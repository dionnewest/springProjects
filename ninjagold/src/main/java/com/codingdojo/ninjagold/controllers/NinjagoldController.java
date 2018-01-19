package com.codingdojo.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class NinjagoldController {
	public static int gold = 0;
	public static int totalGold;
	public static ArrayList<String> messages = new ArrayList<String>();

	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("totalGold", totalGold);
		model.addAttribute("messages", messages);
		return "index.jsp";
	}
	@RequestMapping(path="/getMoney", method=RequestMethod.POST)
    public String getMoney(HttpSession session, @RequestParam(value="location") String location) {
		if(location.equals("farm")) {
			session.setAttribute("min", 10);
			session.setAttribute("max", 20);
		} else if (location.equals("cave")){
			session.setAttribute("min", 5);
			session.setAttribute("max", 10);
		} else if (location.equals("house")) {
			session.setAttribute("min", 2);
			session.setAttribute("max", 5);
		} else if(location.equals("casino")) {
			session.setAttribute("min", -50);
			session.setAttribute("max", 50);
		}
		int min = (int) session.getAttribute("min");
		int max = (int) session.getAttribute("max");
		Random random = new Random();
		int newGold = random.nextInt(max + 1 - min) + min;
		gold += newGold;
		if (session.getAttribute("totalGold") == null && session.getAttribute("message") == null) {
    			session.setAttribute("totalGold", gold);
    			if(newGold >= 0) {
    				session.setAttribute("message", "Welcome to Ninja Gold! You entered a " + location + " and earned " + newGold + " pieces of gold. Good luck in your adventure.");
	    		} else {
	    			session.setAttribute("message", "Welcome to Ninja Gold! It looks like you're off to a bad start, losing " + newGold + " pieces of gold in the casino already. May the odds be ever in your favor.");
	    		}
    			

	    	} else {
	    		session.setAttribute("totalGold", gold);
	    		if(newGold >= 0) {
	    			session.setAttribute("message", "You entered a " + location + " and earned " + newGold + " pieces of gold.");
	    		} else {
	    			session.setAttribute("message", "You entered a " + location + " and lossed " + newGold + " pieces of gold. Quit while you're ahead.");
	    		}
	    	}
		totalGold = (int) session.getAttribute("totalGold");
		String message = (String) session.getAttribute("message");
		messages.add(message);
    		return "redirect:/";
}
	@RequestMapping(path="/reset", method=RequestMethod.POST)
	public String reset(HttpSession session) {
		session.setAttribute("totalGold", null);
		session.setAttribute("message",  null);
		gold = 0;
		totalGold = 0;
		messages = new ArrayList<String>();
		return "redirect:/";
	}
}