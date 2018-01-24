package com.codingdojo.dojosAndNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosAndNinjas.models.Dojo;
import com.codingdojo.dojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoServices{
	private DojoRepository dojoRepository;
	public DojoServices(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public void addDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	public Dojo findDojo(Long id) {
		return dojoRepository.findOne(id);
	}
}