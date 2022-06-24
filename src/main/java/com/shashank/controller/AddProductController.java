package com.shashank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.dao.ProductDao;
import com.shashank.models.Product;

@WebServlet("/addProduct")
public class AddProductController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String productName = request.getParameter("productName");
		String productBrand = request.getParameter("productBrand");
		int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
		
		Product product = new Product(productName,productBrand,productQuantity);
		try {
		ProductDao dao = new ProductDao();
		dao.connection();
		boolean isProductAdded = dao.addProduct(product);
		
			if (isProductAdded) {
				RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
				request.setAttribute("cnfMsg","Product added successfully...");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
				request.setAttribute("cnfMsg","Something went wrong, please try again...");
				rd.forward(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
		
		
	}

}
