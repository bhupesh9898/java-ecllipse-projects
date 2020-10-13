package com.zensar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.models.User;
import com.zensar.service.ProductService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Getting Service Provider
		ProductService impl = IndexServlet.getServiceProvider();

		// Getting user name and password from login form
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		PrintWriter out = response.getWriter();

		// Checking user is authenticated or not
		try {
			User user = impl.loginUser(userName, password);
			request.setAttribute("user", user);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert(' " + e.getMessage() + " ');");
			out.println("location='index.jsp';");
			out.println("</script>");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
