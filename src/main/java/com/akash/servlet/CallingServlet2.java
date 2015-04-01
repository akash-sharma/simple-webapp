package com.akash.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//annotation not working, enty configured in web.xml
@WebServlet("/call2")
public class CallingServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 4L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//Executed
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><h3>starting here for include</h3>");
		
		//Executed
		System.out.println("CallingServlet2.doGet() BEFORE");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath()+"/hello");
		dispatcher.include(request, response);
		
		//Executed
		out.println("<h3>ending here for include</h3></html>");
		
		//Executed
		System.out.println("CallingServlet2.doGet() AFTER");
	}
}