package com.zensar.utilities;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnectionUtil {

	static Connection conn;

	// Method to get mysql connection
	public static Connection getConnection() {

		try {

			Context context = (Context) new InitialContext();
			Context envContext = (Context) context.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/mysql");
			conn = dataSource.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
