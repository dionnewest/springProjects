package com.codingdojo.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class NinjagoldController {
	public static int gold = 0;
	public static int totalGold;
	public static ArrayList<String> messages = new ArrayList<String>();

	@RequestMapping("/")
	public String index(Model model){
		System.out.println(totalGold);
		model.addAttribute("totalGold", totalGold);
		model.addAttribute("messages", messages);
		return "index.jsp";
	}
	@RequestMapping(path="/farm", method=RequestMethod.POST)
    public String farm(HttpSession session) {
		Random random = new Random();
		int newGold = random.nextInt(11) + 10;
		gold += newGold;
		if (session.getAttribute("totalGold") == null && session.getAttribute("message") == null) {
    			session.setAttribute("totalGold", gold);
    			session.setAttribute("message", "Welcome to Ninja Gold! You entered a farm and earned " + newGold + " pieces of gold. Good luck in your adventure.");

	    	} else {
	    		session.setAttribute("totalGold", gold);
	    		session.setAttribute("message", "You entered a farm and earned " + newGold + " pieces of gold.");
	    	}
		totalGold = (int) session.getAttribute("totalGold");
		String message = (String) session.getAttribute("message");
		messages.add(message);
    		return "redirect:/";
    }
	@RequestMapping(path="/cave", method=RequestMethod.POST)
    public String cave(HttpSession session) {
		Random random = new Random();
		int newGold = random.nextInt(6) + 5;
		gold += newGold;
		if (session.getAttribute("totalGold") == null && session.getAttribute("message") == null) {
    			session.setAttribute("totalGold", gold);
    			session.setAttribute("message", "Welcome to Ninja Gold! You entered a cave and earned " + newGold + " pieces of gold. Good luck in your adventure.");

	    	} else {
	    		session.setAttribute("totalGold", gold);
	    		session.setAttribute("message", "You entered a cave and earned " + newGold + " pieces of gold.");
	    	}
		totalGold = (int) session.getAttribute("totalGold");
		String message = (String) session.getAttribute("message");
		messages.add(message);
		System.out.println("Messages: " + messages);
    		return "redirect:/";
    }
	@RequestMapping(path="/house", method=RequestMethod.POST)
    public String house(HttpSession session) {
		Random random = new Random();
		int newGold = random.nextInt(4) + 2;
		gold += newGold;
		if (session.getAttribute("totalGold") == null && session.getAttribute("message") == null) {
    			session.setAttribute("totalGold", gold);
    			session.setAttribute("message", "Welcome to Ninja Gold! You entered a house and earned " + newGold + " pieces of gold. Good luck in your adventure.");
	    	} else {
	    		session.setAttribute("totalGold", gold);
	    		session.setAttribute("message", "You entered a house and earned " + newGold + " pieces of gold.");
	    	}
		totalGold = (int) session.getAttribute("totalGold");
		String message = (String) session.getAttribute("message");
		messages.add(message);
		System.out.println("Messages: " + messages);
    		return "redirect:/";
    }
	@RequestMapping(path="/casino", method=RequestMethod.POST)
    public String casino(HttpSession session) {
		Random random = new Random();
		int newGold = random.nextInt(101) - 50;
		gold += newGold;
		if (session.getAttribute("totalGold") == null && session.getAttribute("message") == null) {
    			session.setAttribute("totalGold", gold);
    			session.setAttribute("message", "Welcome to Ninja Gold! You entered a casino and earned " + newGold + " pieces of gold. Good luck in your adventure.");
	    	} else {
	    		session.setAttribute("totalGold", gold);
	    		session.setAttribute("message", "You entered a house and earned " + newGold + " pieces of gold.");
	    	}
		totalGold = (int) session.getAttribute("totalGold");
		String message = (String) session.getAttribute("message");
		messages.add(message);
		System.out.println("Messages: " + messages);
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