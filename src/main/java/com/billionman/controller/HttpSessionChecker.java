/**
 * 
 */
package com.billionman.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * @author CTM
 *
 */
public class HttpSessionChecker extends DelegatingFilterProxy implements Filter {

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("-------------------Logged in:");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("---------------Log out:");
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		super.doFilter(req, res, chain);
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getServletPath();
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		System.out.println("=--------------------session: "
				+ attr.getRequest().getSession(true) + "   "
				+ request.isSecure());
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
