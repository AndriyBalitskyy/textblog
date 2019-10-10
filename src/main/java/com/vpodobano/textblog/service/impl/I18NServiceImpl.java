package com.vpodobano.textblog.service.impl;

import java.util.Locale;
import java.util.ResourceBundle;

import com.vpodobano.textblog.service.I18NService;

class I18NServiceImpl implements I18NService {

	@Override
	public String getMessage(String key, Locale locale, Object... args) {
	
		String value = ResourceBundle.getBundle("i18n/messages", new Locale("uk")).getString(key);
		
		for(int i=0; i< args.length; i++) {
			value = value.replace("{" + i + "}", args[i].toString());
		}
		
		return value;
	}

}
