package com.shashank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
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
	
	
	public List<Product> getProductList() throws SQLException{
		String query = "select * from products";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		List<Product>productList =new ArrayList<>();
		while(rs.next()) {
			Product product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			productList.add(product);
		}
		return productList;
	}
	
	public void deleteProduct(int id) throws SQLException {
		String query = "delete from products WHERE id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.executeUpdate();
	}
	
	public boolean updateProduct(Product product) {
		try {
			String query = "UPDATE products set name=?,brand=?,quantity=? WHERE id=?;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,product.getName());
			pst.setString(2,product.getBrand());
			pst.setInt(3,product.getQuantity());
			pst.setInt(4,product.getId());
			pst.executeUpdate();	
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Product getProductById(int id) throws SQLException {
		String query = "select * from products WHERE id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		rs.next();
		Product product = new Product(id,rs.getString(2),rs.getString(3),rs.getInt(4));
		return product;
	}
	
}
