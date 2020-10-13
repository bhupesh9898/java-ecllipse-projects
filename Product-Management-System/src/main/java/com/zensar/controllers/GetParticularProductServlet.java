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

public class GetParticularProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Getting Service Provider
		ProductService impl = IndexServlet.getServiceProvider();
		PrintWriter out = response.getWriter();

		// Getting value of product id from user
		int productId = Integer.valueOf(request.getParameter("product-id"));

		Product product = null;
		RequestDispatcher dispatcher = request.getRequestDispatcher("single_product.jsp");

		// Checking session is maintained or not
		HttpSession session = request.getSession(false);
		if (session == null || (User)session.getAttribute("user") == null ) {
			System.out.println("Session timed out..");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Session timed out, please login again !!');");
			out.println("location='index.jsp';");
			out.println("</script>");
		} else {
			product = impl.getProduct(productId);
			if (product != null) {
				// Setting values to get in jsp
				request.setAttribute("productId", product.getProductId());
				request.setAttribute("productName", product.getProductName());
				request.setAttribute("productPrice", product.getProductCost());
				dispatcher.forward(request, response);
				// If id not found then exception executes
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Sorry, product id not found, cannot get product');");
				out.println("location='get_product.html';");
				out.println("</script>");
			}
		}

	}

}
