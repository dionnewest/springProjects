package com.codingdojo.crudAssignment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.crudAssignment.models.Language;
import com.codingdojo.crudAssignment.services.LanguageService;

@Controller
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService){
        this.languageService = languageService;
    }
    @RequestMapping("/")
    public String home() {
    	return "redirect:/languages";
    }
    //READ
    @RequestMapping("/languages")
    public String languages(Model model, @ModelAttribute("language") Language language){
        List<Language> allLanguages = languageService.allLanguages();
        model.addAttribute("allLanguages", allLanguages);
    	return "language.jsp";
    }
    @RequestMapping("/languages/{id}")
    public String showLanguage(@PathVariable("id") Long id, Model model){
        Language language = languageService.findLanguageById(id);
        model.addAttribute("language", language);
        return "showLanguage.jsp";
    }
    //CREATE
    @PostMapping("/languages/new")
    public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result){
    	System.out.println("Create language route works");
        if(result.hasErrors()){
            return "language.jsp";
        }else{
            languageService.addLanguage(language);
            return "redirect:/languages";
        }
    }
    //UPDATE
    @RequestMapping("/languages/edit/{id}")
    public String editLanguage(@PathVariable("id") Long id, Model model){
        Language language = languageService.findLanguageById(id);
        if (language != null){
            model.addAttribute("language", language);
            return "editLanguage.jsp";
        }else{
            return "redirect:/languages";
        }
    }
    @PostMapping("/languages/edit/{id}")
    public String updateLanguage(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result){
        if(result.hasErrors()){
            return "editLanguage.jsp";
        }else{
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    //DELETE
    @RequestMapping("/languages/delete/{id}")
    public String destroyLanguage(@PathVariable("id") Long id){
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }

}