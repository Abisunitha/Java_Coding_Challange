package com.model;

public class Product {
   
	private int product_id;
	private String product_name;
	private String description;
	private double price;
	private int stock_quantity;
	private String type;
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", description=" + description
				+ ", price=" + price + ", stock_quantity=" + stock_quantity + ", type=" + type + "]";
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int product_id, String product_name, String description, double price, int stock_quantity,
			String type) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.description = description;
		this.price = price;
		this.stock_quantity = stock_quantity;
		this.type = type;
	}
}
