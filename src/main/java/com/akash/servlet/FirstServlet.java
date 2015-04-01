package com.akash.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><h3>hello to my first servlet</h3></html>");
		System.out.println("FirstServlet.service()");
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext context=getServletContext();
		context.setAttribute("name", "internal name");
		System.out.println("FirstServlet.init()");
	}

	public ServletContext getServletContext() {
		ServletContext servletContext = super.getServletContext();
		System.out.println("FirstServlet.getServletContext() = "
				+ servletContext);
		return servletContext;
	}

	public void destroy() {
		super.destroy();
		System.out.println("FirstServlet.destroy()");
	}

	public String getServletInfo() {

		System.out.println("FirstServlet.getServletInfo()");
		return "my first servlet";
	}
}
