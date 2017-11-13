package com.epam.lsp.repository;

import java.util.List;

import com.epam.lsp.model.Category;
import com.epam.lsp.model.Product;

public abstract class IProductContext {

	 private List<Category> categories;
	 private List<Product> products;
	public List<Category> getCategories() {
		return categories;
	}
	public List<Product> getProducts() {
		return products;
	}
	 
	 
	 
}
