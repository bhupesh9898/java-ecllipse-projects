package com.zensar.service;

import com.zensar.controllers.IndexServlet;
import com.zensar.exceptions.InvalidEmailException;
import com.zensar.exceptions.InvalidLoginCredentialsException;
import com.zensar.models.Product;
import com.zensar.models.User;
import com.zensar.repository.ProductRepository;

public class ProductServiceImpl implements ProductService{

	// Loose coupling done by getting repository provider from web.xml
	ProductRepository impl = IndexServlet.getRepositoryProvider();
	

	public int acceptProduct(String productName, int productCost) {
		return impl.insertProduct(new Product(productName, productCost));
	}

	
	@Override
	public boolean deleteProduct(int productId) {
		return impl.deleteProduct(productId);
	}


	@Override
	public Product getProduct(int productId){
		return impl.getProduct(productId);
	}

	
	@Override
	public Product[] getAllProducts() {
		return impl.getAllProducts();
	}

	
	@Override
	public User loginUser(String userName, String password) throws Exception {
		User user = impl.loginUser(userName, password);
		if(user == null)
			throw new InvalidLoginCredentialsException("Sorry email id or password is wrong, "
					+ "Please enter correct login details");
		else
			return user;
	}

	@Override
	public int registerUser(User user) throws Exception {
		int check = impl.registerUser(user);
		if(check == 0)
			throw new InvalidEmailException("Sorry this email id is already registered, "
					+ "please register with different mail id");
		else
			return check;
	}


	@Override
	public int updateProduct(int productId, Product product) {
		return impl.updateProduct(productId, product);
	}
	
}
