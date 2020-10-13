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

public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Getting Service Provider
		ProductService impl = IndexServlet.getServiceProvider();

		// Getting product id from user
		int productId = Integer.valueOf(request.getParameter("product-id"));
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
			// Calling Method to delete the product
			boolean check = impl.deleteProduct(productId);
			if (check) {
				System.out.println("Product deleted successfully !!!");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Product deleted Successfully !!!');");
				out.println("location='menu.jsp';");
				out.println("</script>");
			} else {
				System.out.println("Sorry cannot deleted product !!!");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Sorry cannot delete product, product id not found !!!');");
				out.println("location='menu.html';");
				out.println("</script>");
			}
		}

	}

}
