package com.epam.lsp.URHealthService;

import java.util.List;

import com.epam.lsp.model.IProductRepository;
import com.epam.lsp.model.Product;
import com.epam.lsp.repository.ProductContext;
import com.epam.lsp.repository.ProductRepository;

public class ProductService {
 
	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository2){
		
		this.productRepository = productRepository2;
	}

	 public List<Product> getAllProducts(){
		 List<Product> products = productRepository.getAllProducts();
		 return products;
	 }
}
