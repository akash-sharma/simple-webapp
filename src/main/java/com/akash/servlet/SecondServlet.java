package com.akash.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	private static final long serialVersionUID = 2L;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		ServletConfig servletConfig = getServletConfig();
		String name = servletConfig.getInitParameter("name");
		
		ServletContext context=getServletContext();
		String nameInContext = (String)context.getInitParameter("name");
		String nameAsAttribute = (String)context.getAttribute("name");
		
		out.println("<html><h3>hello to my second servlet<br>");
		out.println(" servlet config init parameter :"+name+"<br>");
		out.println(" servlet context init parameter : "+nameInContext+"<br>");
		out.println(" servlet context attribute : "+nameAsAttribute);
		out.println("</h3></html>");
		
		System.out.println("SecondServlet.service()");
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String name = config.getInitParameter("name");
		System.out.println("SecondServlet.init() name:"+name);
	}
}