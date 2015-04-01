package com.akash.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//annotation not working, enty configured in web.xml
@WebServlet("/call1")
public class CallingServlet1 extends HttpServlet {

	private static final long serialVersionUID = 3L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//Executed
		System.out.println("CallingServlet1.doGet() BEFORE");
		
		//Not Executed
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><h3>starting here for sendredirect</h3></html>");
		
		response.sendRedirect(request.getContextPath()+"/hello");
		
		//Executed
		//This will be executed first, before service method of calling servlet
		System.out.println("CallingServlet1.doGet() AFTER");
	}
}

/**
* Output=>
* 
* BEFORE
* AFTER
* service()
* 
*/