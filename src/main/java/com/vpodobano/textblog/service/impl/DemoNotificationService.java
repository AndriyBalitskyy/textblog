package com.vpodobano.textblog.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vpodobano.textblog.service.NotificationService;

public class DemoNotificationService implements NotificationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoNotificationService.class);
	@SuppressWarnings("unused")
	private final ServiceManager serviceManager;
	
	
	public DemoNotificationService(ServiceManager serviceManager) {
		super();
		this.serviceManager = serviceManager;
	}


	@Override
	public void sendNotification(String title, String content) {
		LOGGER.info("New comment: title=" + title + ", content=" + content);
	}
	
	

	@Override
	public void shutdown() {
		// do nothing

	}

}
