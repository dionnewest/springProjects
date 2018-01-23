package com.codingdojo.crudAssignment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.crudAssignment.models.Language;
import com.codingdojo.crudAssignment.repositories.LanguageRepository;

@Service
public class LanguageService{
    private LanguageRepository languageRep;
    public LanguageService(LanguageRepository languageRep) {
    		this.languageRep = languageRep;
    }
    public List<Language> allLanguages(){
    		return languageRep.findAll();
    }
    //CREATE
    public void addLanguage(Language language) {
    		languageRep.save(language);
    }
    //READ
    public Language findLanguageById(Long id) {
    		return languageRep.findOne(id);
    }
    //UPDATE
    public void updateLanguage(Language language) {
    		languageRep.save(language);
    }
    //DELETE
    public void deleteLanguage(Long id) {
    		languageRep.delete(id);
    }
}