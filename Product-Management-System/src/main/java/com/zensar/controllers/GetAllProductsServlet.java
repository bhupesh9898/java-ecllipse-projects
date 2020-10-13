package com.zensar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensar.models.Product;
import com.zensar.models.User;
import com.zensar.service.ProductService;

public class GetAllProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Getting Service Provider
		ProductService impl = IndexServlet.getServiceProvider();

		PrintWriter out = response.getWriter();

		RequestDispatcher dispatcher = request.getRequestDispatcher("get_all_products.jsp");

		// Getting all the products that have been placed
		Product[] retrievedProducts = impl.getAllProducts();

		// Checking session is maintained or not
		HttpSession session = request.getSession(false);
		if (session == null || (User)session.getAttribute("user") == null ) {
			System.out.println("Session timed out..");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Session timed out, please login again !!');");
			out.println("location='index.jsp';");
			out.println("</script>");
		} else {
			// Checking product is empty or not and displaying it
			if (retrievedProducts.length > 0 && retrievedProducts[0] != null) {
				request.setAttribute("allProducts", retrievedProducts);
				dispatcher.forward(request, response);
			}
			// If there is no product in the product list
			else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Sorry for inconvinience, but no product has been found');");
				out.println("location='menu.jsp';");
				out.println("</script>");
			}
		}

	}

}
