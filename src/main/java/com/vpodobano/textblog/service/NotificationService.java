package com.vpodobano.textblog.service;

public interface NotificationService {
	void sendNotification(String title, String content);
	
	void shutdown();
}
