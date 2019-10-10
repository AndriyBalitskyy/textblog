package com.vpodobano.textblog.form;

import java.util.Locale;

import com.vpodobano.textblog.exception.ValidateException;
import com.vpodobano.textblog.model.AbstractModel;
import com.vpodobano.textblog.service.I18NService;

public abstract class AbstractForm extends AbstractModel {
	protected Locale locale;

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public void validate(I18NService i18nService) throws ValidateException {
		
	}
}
