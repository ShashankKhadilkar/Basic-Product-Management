package com.shashank.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class NoCacheFilter implements Filter {
		@Override
	    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
			
			System.out.println("in filter");
	        HttpServletRequest request = (HttpServletRequest)servletRequest;
	        HttpServletResponse response = (HttpServletResponse) servletResponse;

	        response.setHeader("Cache-Control", "no-cache, no-store");
	        response.setHeader("Pragma", "no-cache");
	        filterChain.doFilter(request, response);

		}

}
