package com.vpodobano.textblog.listener;

import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vpodobano.textblog.Constants;
import com.vpodobano.textblog.entity.Category;
import com.vpodobano.textblog.service.impl.ServiceManager;

@WebListener
public class ApplicationListener implements ServletContextListener {
	protected final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServiceManager serviceManager = ServiceManager.getInstance(sce.getServletContext());
		Map<Long, Category>  map = serviceManager.getBusinessService().mapCategories();
		sce.getServletContext().setAttribute("social_googleplus_clienId", serviceManager.getApplicationProperty("social.googleplus.clienId"));
		sce.getServletContext().setAttribute(Constants.CATEGORY_MAP, map);
		LOGGER.info("Application started.");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServiceManager.getInstance(sce.getServletContext()).destroy();
		LOGGER.info("Application destroyed.");
	}

}
