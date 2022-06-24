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

@WebServlet("/editProduct/*")
public class EditProductController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EditProductController controller Servlet");
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.substring(1));
		System.out.println(id);
		ProductDao dao = new ProductDao();
		try {
		dao.connection();
		Product product = dao.getProductById(id);
		RequestDispatcher rd = request.getRequestDispatcher("/editProduct.jsp");
		request.setAttribute("product",product);
		rd.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		String productName = request.getParameter("productName");
		String productBrand = request.getParameter("productBrand");
		int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
		
		Product product = new Product(productId,productName,productBrand,productQuantity);
		try {
		ProductDao dao = new ProductDao();
		dao.connection();
		boolean isProductAdded = dao.updateProduct(product);
		
			if (isProductAdded) {
				HttpSession session = request.getSession();
				session.setAttribute("cnfMsg","Product updated successfully...");
				response.sendRedirect(request.getContextPath() +"/viewProduct");
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("cnfMsg","Somthing went wrong, please try again...");
				response.sendRedirect(request.getContextPath() +"/viewProduct");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
