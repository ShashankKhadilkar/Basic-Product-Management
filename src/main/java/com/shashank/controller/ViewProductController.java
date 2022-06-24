package com.shashank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashank.dao.ProductDao;
import com.shashank.models.Product;

@WebServlet("/viewProduct")
public class ViewProductController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ViewProductController controller Servlet");
		ProductDao dao = new ProductDao();
		try {
			dao.connection();
			List<Product>productList = dao.getProductList();
			RequestDispatcher rd = request.getRequestDispatcher("/viewProduct.jsp");
			request.setAttribute("productList",productList);
			rd.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}


}
