package com.codingdojo.store.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.store.models.Category;
import com.codingdojo.store.repositories.CategoryRepository;

@Service
public class CategoryService{
	private CategoryRepository categoryRep;
	public CategoryService(CategoryRepository categoryRep) {
		this.categoryRep = categoryRep;
	}
	
	public List<Category> allCategories(){
		return categoryRep.findAll();
	}
	public void addCategory(Category category) {
		categoryRep.save(category);
	}
	
	public Category lookupCategory(Long id) {
		return categoryRep.findOne(id);
	}

	public void deleteAllCategories() {
		categoryRep.deleteAll();
	}
}