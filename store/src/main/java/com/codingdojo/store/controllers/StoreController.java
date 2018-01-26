package com.codingdojo.store.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.store.models.Category;
import com.codingdojo.store.models.Product;
import com.codingdojo.store.services.CategoryService;
import com.codingdojo.store.services.ProductService;

@Controller
public class StoreController{
	private final ProductService productService;
	private final CategoryService categoryService;
	public StoreController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	@RequestMapping("/")
	public String test() {
		return "test.jsp";
	}
	@RequestMapping("/products")
	public String products(Model model) {
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		return "products.jsp";
	}
//	public String deleteProducts() {
//		productService.deleteAllProducts();
//		return "products.jsp";
//	}
	@RequestMapping("/categories")
	public String categories(Model model) {
		List<Category> categories = categoryService.allCategories();
		model.addAttribute("categories", categories);
		return "categories.jsp";
	}
//	public String deleteCategories() {
//		 categoryService.deleteAllCategories();
//		 return "categories.jsp";
//	}
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		}else {
			productService.addProduct(product);
			return "redirect:/products";
		}
	}
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}else {
			categoryService.addCategory(category);
			return "redirect:/categories";
		}
	}
	@RequestMapping("/products/{id}")
	public String viewProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.lookupProduct(id);
		model.addAttribute("product", product);
		List<Category> categories = categoryService.allCategories();
		List<Category> productCats = product.getCategories();
		List<Category> notCategories = categories;
		Long start = categories.get(0).getId();
		Long end = categories.get(categories.size()-1).getId();
		for(Long i = start; i <= end; i++) {
		Category category = categoryService.lookupCategory(i);
		if(productCats.contains(category)) {
			notCategories.remove(category);
		}
	}
		model.addAttribute("categories", notCategories);
		model.addAttribute("productCats", productCats);
		return "productProfile.jsp";
	}
	@PostMapping("/products/{id}")
	public String addCategory(@PathVariable("id") Long id, @RequestParam("categoryId") Long categoryId, Model model) {
		Product product = productService.lookupProduct(id);
		Category category = categoryService.lookupCategory(categoryId);
		List <Category> categories = product.getCategories();
		categories.add(category);
		product.setCategories(categories);
		productService.addProduct(product);
		return "redirect:/products/"+id;
	}
	@RequestMapping("/categories/{id}")
	public String viewCategory(@PathVariable("id") Long id, Model model) {
		System.out.println("category id route works");
		Category category = categoryService.lookupCategory(id);
		model.addAttribute("category", category);
		List<Product> products = productService.allProducts();
		List<Product> catProducts = category.getProducts();
		List<Product> notProducts = products;
		Long start = products.get(0).getId();
		Long end = products.get(products.size()-1).getId();
		for(Long i = start; i <= end; i++) {
			Product product = productService.lookupProduct(i);
			if(catProducts.contains(product)) {
				notProducts.remove(product);
			}
		}
		model.addAttribute("products", notProducts);
		model.addAttribute("catProducts", catProducts);
		return "categoryProfile.jsp";
	}
	@PostMapping("/categories/{id}")
	public String addProduct(@PathVariable("id") Long id, @RequestParam("productId") Long productId, Model model) {
		Category category = categoryService.lookupCategory(id);
		Product product = productService.lookupProduct(productId);
		List<Product> products = category.getProducts();
		products.add(product);
		category.setProducts(products);
		categoryService.addCategory(category);
		return "redirect:/categories/"+id;
	}
}