package com.zensar.service;

import com.zensar.models.Product;
import com.zensar.models.User;

public interface ProductService {

	// Method declared to accept product which is to be defined by the implementor class
	public int acceptProduct(String productName, int productCost);

	// Method declared to delete product which is to be defined by the implementor class
	public boolean deleteProduct(int productId);

	// Method declared to get particular product which is to be defined by the implementor class
	public Product getProduct(int productId);

	// Method declared to get all product which is to be defined by the implementor class
	public Product[] getAllProducts();
	
	// Method declared to update product which is to be defined by the implementor class
	public int updateProduct(int productId, Product product);

	// Method to login user which is to be defined by the implementor class
	public User loginUser(String userName, String password) throws Exception;

	// Method to register user which is to be defined by the implementor class
	public int registerUser(User user) throws Exception;
	
}
