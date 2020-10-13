package com.zensar.models;

public class Product {

	// Data members
	private int productId;
	private String productName;
	private int productCost;
	
	// Constructors
	public Product() {
		super();
	}
	
	public Product(String productName, int productCost) {
		super();
		this.productName = productName;
		this.productCost = productCost;
	}

	public Product(int productId, String productName, int productCost) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
	}

	// accessesor's and mutator's
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getProductCost() {
		return productCost;
	}
	
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	// ToString method overridden
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ "]";
	}
	
	
	
}
