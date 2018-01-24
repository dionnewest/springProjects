package com.codingdojo.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class PersonServices{
	private PersonRepository personRep;
	public PersonServices(PersonRepository personRep) {
		this.personRep = personRep;
	}
	public List<Person> allPeople(){
		return personRep.findAll();
	}
	public void createPerson(Person person) {
		personRep.save(person);
	}
	public Person lookupPerson(Long id) {
		return personRep.findOne(id);
	}
}