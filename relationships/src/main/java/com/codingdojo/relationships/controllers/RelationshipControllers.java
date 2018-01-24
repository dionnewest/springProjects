package com.codingdojo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseServices;
import com.codingdojo.relationships.services.PersonServices;

@Controller
public class RelationshipControllers{
	private final PersonServices personService;
	private final LicenseServices licenseService;
	
	public RelationshipControllers(PersonServices personService, LicenseServices licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}

	@RequestMapping("/")
	public String index() {
		return "redirect:/people";
	}
	@RequestMapping("/people")
	public String allPeople(Model model) {
		List<Person> people = personService.allPeople();
		model.addAttribute("people", people);
		return "people.jsp";
	}
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	
	@PostMapping("/persons/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "newPerson.jsp";
		}else {
			personService.createPerson(person);
			return "redirect:/licenses/new";
		}
	}
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> people = personService.allPeople();
		model.addAttribute("people", people);
		return "newLicense.jsp";
	}
//	public String deleteLicenses() {
//		licenseService.deleteAllLicenses();
//		return "newLicense.jsp";
//	}
	@PostMapping("/licenses/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Person> people = personService.allPeople();
			model.addAttribute("people", people);
			return "newLicense.jsp";
		}else {
			licenseService.createLicense(license);
			return "redirect:/licenses/new";
		}
	}
	@RequestMapping("/persons/{id}")
	public String profile(Model model, @PathVariable("id") Long id) {
		model.addAttribute("person", personService.lookupPerson(id));
		return "profile.jsp";
	}
	
}