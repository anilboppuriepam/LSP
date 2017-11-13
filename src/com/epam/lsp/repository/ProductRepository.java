package com.epam.lsp.repository;

import java.util.List;

import com.epam.lsp.model.IProductRepository;
import com.epam.lsp.model.Product;

public class ProductRepository implements IProductRepository{

	private IProductContext dbContext;
	
	
	public ProductRepository(IProductContext dbContext) {
		this.dbContext = dbContext;
	}


	@Override
	public List<Product> getAllProducts() {
		List<Product> products = dbContext.getProducts();
		return products;
	}
	
	

}
