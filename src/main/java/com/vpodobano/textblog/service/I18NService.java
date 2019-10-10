package com.vpodobano.textblog.service;

import java.util.Locale;

public interface I18NService {
	String getMessage(String key, Locale locale, Object...args);
}
