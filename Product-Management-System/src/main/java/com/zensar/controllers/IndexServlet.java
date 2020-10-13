package com.zensar.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.repository.ProductRepository;
import com.zensar.service.ProductService;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Using ServletContext that is at application level
	ServletContext servletContext = null;
	static String serviceProvider = null, repositoryProvider = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		servletContext = config.getServletContext();
		serviceProvider = servletContext.getInitParameter("serviceProvider");
		repositoryProvider = servletContext.getInitParameter("repositoryProvider");
		System.out.println("Default Servlet executed...........");
	}

	// Method to get service provider
	public static ProductService getServiceProvider() {
		try {
			return (ProductService) Class.forName(serviceProvider).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Method to get repository provider
	public static ProductRepository getRepositoryProvider() {
		try {
			return (ProductRepository) Class.forName(repositoryProvider).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// default page index.jsp is called and this servlet runs and sets
	// service provider and repository provider
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

}
