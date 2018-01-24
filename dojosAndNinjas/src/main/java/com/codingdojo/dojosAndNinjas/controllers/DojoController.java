package com.codingdojo.dojosAndNinjas.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojosAndNinjas.models.Dojo;
import com.codingdojo.dojosAndNinjas.models.Ninja;
import com.codingdojo.dojosAndNinjas.services.DojoServices;
import com.codingdojo.dojosAndNinjas.services.NinjaService;

@Controller
public class DojoController{
	private final DojoServices dojoService;
	private final NinjaService ninjaService;
	public DojoController(DojoServices dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/dojos")
	public String alldojos(Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "allDojos.jsp";
	}
	@RequestMapping("/ninjas")
	public String allninjas(Model model) {
		List<Ninja> ninjas = ninjaService.allNinjas();
		model.addAttribute("ninjas", ninjas);
		return "allNinjas.jsp";
	}
	@RequestMapping("/dojos/new")
	public String dojos(@ModelAttribute("dojo") Dojo dojo) {
		return "addDojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo) {
		dojoService.addDojo(dojo);
		return "redirect:/dojos";
	}
	@RequestMapping("/ninjas/new")
	public String ninjas(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos(); //import to provide information for drop down list of Dojo Locations in form
		model.addAttribute("dojos", dojos);
		return "addNinja.jsp";
	}
	@PostMapping("/ninjas/new")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja) {
		ninjaService.addNinja(ninja);
		return "redirect:/ninjas";
	}
	@RequestMapping("/dojos/{id}")
	public String selectDojo(@PathVariable("id") Long id, Model model) {
		Dojo location = dojoService.findDojo(id);
		List <Ninja> ninjas = ninjaService.allNinjas();
		List<Ninja> dojoninjas = new ArrayList<>();
		System.out.println(ninjas.size());
		for(int i = 0; i < ninjas.size(); i++) {
			Ninja ninja = ninjas.get(i);
			System.out.println("Ninja's location: " + ninja.getDojo().getName());
			System.out.println("Dojo Location: " + location.getName());
			if(ninja.getDojo() == location) {
				dojoninjas.add(ninja);
			}
		}
		model.addAttribute("ninjas", dojoninjas);
		model.addAttribute("dojo", location);
		return "dojoProfile.jsp";
	}
}