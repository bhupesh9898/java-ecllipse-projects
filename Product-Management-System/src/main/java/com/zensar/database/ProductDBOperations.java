package com.zensar.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.zensar.models.Product;
import com.zensar.utilities.DBConnectionUtil;

public class ProductDBOperations {

	// Method to add product into the database
	public static int addProduct(Product product) {

		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement statement;
		int check = 0;

		try {
			statement = con.prepareStatement("insert into product_details(name,cost)values(?,?)");
			statement.setString(1, product.getProductName());
			statement.setInt(2, product.getProductCost());

			check = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	// Method to get all the products from the database
	public static Product[] getAllProducts() {

		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement statement;
		ResultSet rs;
		Product[] products = new Product[100];
		try {

			statement = con.prepareStatement("select * from product_details");
			rs = statement.executeQuery();

			int i = 0;
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductCost(rs.getInt(3));
				products[i] = product;
				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	// Method to get particular product from the database
	public static Product getProduct(int productId) {

		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement statement;
		ResultSet rs;
		Product product = null;
		try {

			statement = con.prepareStatement("select * from product_details where id = ?");
			statement.setInt(1, productId);

			rs = statement.executeQuery();

			if (rs.next() ) {
				product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductCost(rs.getInt(3));
				System.out.println("Hi-----------------");
			}
			System.out.println("produt-----------" + product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	// Method to delete particular product from the database
	public static boolean deleteProduct(int productId) {

		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement statement;
		boolean value = false;
		try {

			statement = con.prepareStatement("delete from product_details where id = ?");
			statement.setInt(1, productId);

			int check = statement.executeUpdate();
			System.out.println("check value--------" + check);
			if (check > 0) {
				value = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("value value-----------" + value);
		return value;
	}

	// Method to update product into the database
	public static int updateProduct(int productId, Product product) {

		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement statement;
		int check = 0;

		System.out.println("id :-" + product.getProductId() );
		System.out.println("name :-" + product.getProductName() );
		System.out.println("price :-" + product.getProductCost() );
		try {
			statement = con.prepareStatement("update product_details set name=?,cost=? where id=?");
			statement.setString(1, product.getProductName());
			statement.setInt(2, product.getProductCost());
			statement.setInt(3, product.getProductId());

			check = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

}
