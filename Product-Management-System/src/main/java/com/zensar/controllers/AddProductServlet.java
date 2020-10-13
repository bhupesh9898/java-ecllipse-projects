package com.zensar.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensar.models.User;
import com.zensar.service.ProductService;

public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Getting Service Provider
		ProductService impl = IndexServlet.getServiceProvider();

		// Getting details of product from user
		String productName = request.getParameter("product-name");
		int productCost = Integer.valueOf(request.getParameter("product-cost"));

		PrintWriter out = response.getWriter();

		// Checking session is maintained or not
		HttpSession session = request.getSession(false);
		if (session == null || (User)session.getAttribute("user") == null ) {
			System.out.println("Session timed out..");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Session timed out, please login again !!');");
			out.println("location='index.jsp';");
			out.println("</script>");
		} else {
			// Method calling to add product
			int result = impl.acceptProduct(productName, productCost);

			// If product is added then it executes
			if (result > 0) {
				System.out.println("Product added successfully !!!");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Product added successfully !!!');");
				out.println("location='menu.jsp';");
				out.println("</script>");
				// If product cannot be added then it executes
			} else {
				System.out.println("Sorry for inconvinience, product not added !!!");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Sorry for inconvinience, server problem, try again');");
				out.println("location='add_product.html';");
				out.println("</script>");
			}
		}

	}

}
