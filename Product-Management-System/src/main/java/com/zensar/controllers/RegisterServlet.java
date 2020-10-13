package com.zensar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.models.User;
import com.zensar.service.ProductService;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Getting Service Provider
		ProductService impl = IndexServlet.getServiceProvider();

		User user = new User();

		// Getting details of user from registration form
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setGender(request.getParameter("gender"));
		user.setDob(request.getParameter("dob"));
		user.setMobile(request.getParameter("mobile"));
		user.setPassword(request.getParameter("password"));

		PrintWriter out = response.getWriter();

		try {
			impl.registerUser(user);
			System.out.println("User registered successfully");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registered Successfully');");
			out.println("location='index.jsp';");
			out.println("</script>");
		} catch (Exception e) {
			System.out.println("User can't be registered");
			out.println("<script type=\"text/javascript\">");
			out.println("alert(' " + e.getMessage() + " ');");
			out.println("location='register.html';");
			out.println("</script>");
		}
	}
}
