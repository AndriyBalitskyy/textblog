package com.vpodobano.textblog.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "ErrorHandlerFilter", urlPatterns = "/*")
public class ErrorHandlerFilter extends AbstractFilter {
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			chain.doFilter(request, response);
		} catch (Throwable th) {
			String requestUrl = request.getRequestURI();
			LOGGER.error("Error during processing the request: " + requestUrl, th);
			if (requestUrl.startsWith("/ajax/")) {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			} else if (!requestUrl.startsWith("/error")) {
				response.sendRedirect("/error");
			} else {
				throw new ServletException(th);
			}
		}
	}
}
