package com.zensar.repository;

import com.zensar.models.Product;
import com.zensar.models.User;

public interface ProductRepository {

	// Method declared to insert product which is to be defined by the implementor class
	public int insertProduct(Product product);
	
	// Method declared to delete product which is to be defined by the implementor class
	public boolean deleteProduct(int productId);
	
	// Method declared to get particular product which is to be defined by the implementor class
	public Product getProduct(int productId);
	
	// Method declared to get all products which is to be defined by the implementor class
	public Product[] getAllProducts();
	
	// Method declared to update product which is to be defined by the implementor class
	public int updateProduct(int productId, Product product);
	
	// Method to login user
	public User loginUser(String userName, String password) throws Exception;
	
	// Method to register user
	public int registerUser(User user) throws Exception;
}
