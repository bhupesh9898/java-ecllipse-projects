package com.zensar.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.models.User;
import com.zensar.utilities.DBConnectionUtil;
import com.zensar.utilities.EncryptAndDecryptPasswordUtil;

public class UserDBOperations {

	// Method to check login credentials of user in database
	public static User login(String userName, String password) throws Exception {

		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement statement;
		ResultSet rs;

		User user = null;

		try {

			statement = con.prepareStatement("select * from user where email = ?");
			statement.setString(1, userName);

			rs = statement.executeQuery();
			
			if (rs.next()) {
				// Checking that user's password is same as the password during registration or not 
				// Comparing the password using AES decryption method
				if (password.equals(EncryptAndDecryptPasswordUtil.decrypt(rs.getString(7), rs.getString(8)))) {
					user = new User();
					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setGender(rs.getString(3));
					user.setDob(rs.getString(4));
					user.setEmail(rs.getString(5));
					user.setMobile(rs.getString(6));
					user.setPassword(rs.getString(7));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	// Method to register user in database
	public static int register(User user) throws Exception {

		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement statement;
		int check = 0;

		try {

			// Checking email is already registered or not
			boolean validate = isEmailRegistered(user.getEmail());

			if (validate) {
				return 0;
			} else {
				// Setting here the encrypted password
				String secretKey = EncryptAndDecryptPasswordUtil.secretKeyGenerator();
				user.setPassword(EncryptAndDecryptPasswordUtil.encrypt(user.getPassword(), secretKey));
				statement = con.prepareStatement(
						"insert into user (name,gender,dob,email,mobile,password,secretkey)values(?,?,?,?,?,?,?)");
				statement.setString(1, user.getName());
				statement.setString(2, user.getGender());
				statement.setString(3, user.getDob());
				statement.setString(4, user.getEmail());
				statement.setString(5, user.getMobile());
				statement.setString(6, user.getPassword());
				statement.setString(7, secretKey);

				check = statement.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	// Method to check email id is already registered or not
	public static boolean isEmailRegistered(String email) {

		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement statement;
		ResultSet rs;

		try {
			statement = con.prepareStatement("select email from user where email = ?");
			statement.setString(1, email);

			rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
