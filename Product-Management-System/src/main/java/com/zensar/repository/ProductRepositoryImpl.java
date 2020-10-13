package com.zensar.repository;

import com.zensar.database.ProductDBOperations;
import com.zensar.database.UserDBOperations;
import com.zensar.models.Product;
import com.zensar.models.User;

public class ProductRepositoryImpl implements ProductRepository {

	public int insertProduct(Product product) {
		return ProductDBOperations.addProduct(product);
	}

	@Override
	public boolean deleteProduct(int productId) {
		return ProductDBOperations.deleteProduct(productId);
	}

	@Override
	public Product getProduct(int productId) {
		return ProductDBOperations.getProduct(productId);
	}

	@Override
	public Product[] getAllProducts() {
		return ProductDBOperations.getAllProducts();
	}

	@Override
	public User loginUser(String userName, String password) throws Exception {
		return UserDBOperations.login(userName, password);
	}

	@Override
	public int registerUser(User user) throws Exception {
		return UserDBOperations.register(user);
	}

	@Override
	public int updateProduct(int productId, Product product) {
		return ProductDBOperations.updateProduct(productId, product);
	}
}
