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

public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			RequestDispatcher dispatcher = request.getRequestDispatcher("update_on_button.jsp");
			Product updateProduct = new Product();

			// Getting order details as input from user
			updateProduct.setProductId(Integer.valueOf(request.getParameter("product-id")));
			updateProduct.setProductName(request.getParameter("product-name"));
			updateProduct.setProductCost(Integer.valueOf(request.getParameter("product-price")));

			request.setAttribute("product", updateProduct);
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Getting Service Provider
		ProductService impl = IndexServlet.getServiceProvider();
		Product updateProduct = new Product();

		// Getting product details as input from user
		updateProduct.setProductId(Integer.valueOf(request.getParameter("product-id")));
		updateProduct.setProductName(String.valueOf(request.getParameter("product-name")));
		updateProduct.setProductCost(Integer.valueOf(request.getParameter("product-cost")));

		PrintWriter out = response.getWriter();

		// Checking session is maintained or not
		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("Session timed out..");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Session timed out, please login again !!');");
			out.println("location='index.jsp';");
			out.println("</script>");
		} else {
			// Method to update product
			int value = impl.updateProduct(updateProduct.getProductId(), updateProduct);
			if (value > 0) {
				System.out.println("Product updated successfully !!!");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Product updated Successfully');");
				out.println("location='menu.jsp';");
				out.println("</script>");
				// It executes if order cannot be updated
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Sorry cannot update product, wrong product id');");
				out.println("location='update_product.html';");
				out.println("</script>");
			}
		}

	}
}
