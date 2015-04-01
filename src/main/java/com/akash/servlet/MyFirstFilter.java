package com.akash.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//	http://tutorials.jenkov.com/java-servlets/gzip-servlet-filter.html

//annotation not working, enty configured in web.xml
@WebFilter("/")
public class MyFirstFilter implements Filter {

	public void destroy() {

		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("MyFirstFilter.doFilter() before dofilter");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		System.out.println("MyFirstFilter.doFilter() after dofilter");
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}