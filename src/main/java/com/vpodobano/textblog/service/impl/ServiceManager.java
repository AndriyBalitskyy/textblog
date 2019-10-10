package com.vpodobano.textblog.service.impl;

import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vpodobano.textblog.service.AvatarService;
import com.vpodobano.textblog.service.BusinessService;
import com.vpodobano.textblog.service.FileStorageAvatarService;
import com.vpodobano.textblog.service.I18NService;
import com.vpodobano.textblog.service.NotificationService;
import com.vpodobano.textblog.service.SocialService;
import com.vpodobano.textblog.utils.AppUtil;

public class ServiceManager {
	private static final String SERVICE_MANAGER = "SERVICE_MANAGER";
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);
	final BusinessService businessService;
	final BasicDataSource dataSource;
	final Properties applicationProperties = new Properties();
	final ServletContext applicationContext;
	final SocialService socialService;
	final AvatarService avatarService;
	final I18NService i18nService;
	final NotificationService notificationService;
	
	public static ServiceManager getInstance(ServletContext context) {
		ServiceManager instance = (ServiceManager) context.getAttribute(SERVICE_MANAGER);
		if(instance == null) {
			instance = new ServiceManager(context);
			context.setAttribute(SERVICE_MANAGER, instance);
		}
		return instance;
	}
	
	public void destroy() {
		try {
			dataSource.close();
		} catch (SQLException e) {
			LOGGER.info("Close dataSource failed: " + e.getMessage(), e);
		}
		notificationService.shutdown();
		LOGGER.info("ServiceManager instance destroyed.");
	}
	
	public BusinessService getBusinessService() {
		return businessService;
	}
	
	public I18NService getI18nService() {
		return i18nService;
	}
	
	private ServiceManager(ServletContext context) {
		applicationContext = context;
		i18nService = new I18NServiceImpl();
		socialService = new GooglePlusSocialService(this);
		avatarService = new FileStorageAvatarService(this);
		AppUtil.loadProperties(applicationProperties, "application.properties");
		dataSource = createBasicDataSource();
//		notificationService = new DemoNotificationService(this);
		notificationService = new AsyncEmailNotificationService(this);
		businessService = new BusinessServiceImpl(this);
//		businessService = new DemoBusinessService(this);
		LOGGER.info("ServiceManager instance created.");
	}
	
	public String getApplicationProperty(String property) {
		return applicationProperties.getProperty(property);
	}
	
	public ServletContext getApplicationContext() {
		return applicationContext;
	}
	
	private BasicDataSource createBasicDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDefaultAutoCommit(false);
		ds.setRollbackOnReturn(true);
		ds.setDriverClassName(getApplicationProperty("db.driver"));
		ds.setUrl(getApplicationProperty("db.url"));
		ds.setUsername(getApplicationProperty("db.username"));
		ds.setPassword(getApplicationProperty("db.password"));
		ds.setInitialSize(Integer.parseInt(getApplicationProperty("db.pool.initSize")));
		ds.setMaxTotal(Integer.parseInt(getApplicationProperty("db.pool.maxSize")));
		return ds;
	}
}
