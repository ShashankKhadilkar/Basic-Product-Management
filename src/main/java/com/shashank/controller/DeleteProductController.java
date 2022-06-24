package com.shashank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.dao.ProductDao;
import com.shashank.models.Product;

@WebServlet("/deleteProduct/*")
public class DeleteProductController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeleteProductController controller Servlet");
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.substring(1));
		System.out.println(id);
		ProductDao dao = new ProductDao();
		try {
			
			dao.connection();
			dao.deleteProduct(id);
			HttpSession session = request.getSession();
			session.setAttribute("cnfMsg","Product deleted successfully...");
			response.sendRedirect(request.getContextPath() +"/viewProduct");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
