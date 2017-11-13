package com.epam.lsp.model;

public class Product {

	 private String name;
	 private double price;
	 private int id;
	 private String description;
	 private int calories;
	public Product(String name, double price, int id, String description, int calories) {
		super();
		this.name = name;
		this.price = price;
		this.id = id;
		this.description = description;
		this.calories = calories;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	 
	 
}
