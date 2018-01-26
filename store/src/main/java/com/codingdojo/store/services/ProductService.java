package com.codingdojo.store.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.store.models.Product;
import com.codingdojo.store.repositories.ProductRepository;

@Service
public class ProductService{
	private ProductRepository productRep;
	public ProductService(ProductRepository productRep) {
		this.productRep = productRep;
	}
	
	public List<Product> allProducts(){
		return productRep.findAll();
	}
	public void addProduct(Product product) {
		productRep.save(product);
	}
	public Product lookupProduct(Long id) {
		return productRep.findOne(id);
	}

	public void deleteAllProducts() {
		productRep.deleteAll();
	}
}