package com.shashank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shashank.models.Product;

public class ProductDao {

	
Connection con = null;
	
	
	public void connection() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/product_management";
		String username = "root";
		String password = "000000";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);

	}
	
	public boolean addProduct(Product product) throws SQLException {
		try {
			String query = "insert into products(name,brand,quantity) values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,product.getName());
			pst.setString(2,product.getBrand());
			pst.setInt(3,product.getQuantity());
			pst.executeUpdate();	
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
