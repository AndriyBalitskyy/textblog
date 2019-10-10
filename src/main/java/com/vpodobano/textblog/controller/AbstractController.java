package com.vpodobano.textblog.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vpodobano.textblog.form.AbstractForm;
import com.vpodobano.textblog.service.BusinessService;
import com.vpodobano.textblog.service.impl.ServiceManager;


public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
	private BusinessService businessService;
	public final BusinessService getBusinessService() {
		return businessService;
	}
	
	public final int getOffset(HttpServletRequest req, int limit) {
		String val = req.getParameter("page");
		if (val != null) {
			int page = Integer.parseInt(val);
			return (page-1) * limit;
		} else {
			return 0;
		}
	}
	
	@Override
	public void init() throws ServletException {
		businessService = ServiceManager.getInstance(getServletContext()).getBusinessService();
	}
	
	public final void forwardToPage (String jspPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("currentPage", "page/" + jspPage);
		request.getRequestDispatcher("/WEB-INF/jsp/page-template.jsp").forward(request, response);;
	}
	
	public final void forwardToFragment (String jspPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/fragment/" + jspPage).forward(request, response);;
	}
	
	public final <T extends AbstractForm> T createForm(HttpServletRequest req, Class<T> formClass) throws ServletException {
		try {
			T form = formClass.newInstance();
			form.setLocale(req.getLocale());
			BeanUtils.populate(form, req.getParameterMap());
			return form;
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			throw new ServletException(e);
		}
	}
}
