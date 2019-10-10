package com.vpodobano.textblog.controller.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vpodobano.textblog.controller.AbstractController;

@WebServlet("/about")
public class AboutController extends AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6597427866749070977L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forwardToPage("about.jsp", req, resp);
	}
}
