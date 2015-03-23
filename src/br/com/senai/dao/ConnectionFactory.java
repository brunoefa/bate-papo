package br.com.senai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getStackTrace());
			
		} try {
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/batepapo","root","");
//			return DriverManager.getConnection("jdbc:mysql://brunoefa.com:3306/brunoefa_batepapo","brunoefa_user","noite@123");
			
		} catch (SQLException ex) {
			
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			throw new RuntimeException(ex);
		}
	}
}