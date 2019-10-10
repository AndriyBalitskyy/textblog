package com.vpodobano.textblog.form;

import org.apache.commons.lang.StringUtils;
import com.vpodobano.textblog.exception.ValidateException;
import com.vpodobano.textblog.service.I18NService;
import com.vpodobano.textblog.validator.*;

public class ContactForm extends AbstractForm {
	private String name;
	private String email;
	private String text;
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getText() {
		return text;
	}
	@Override
	public void validate(I18NService i18nService) throws ValidateException {
		EmailValidator validator = new EmailValidator();
		if(!validator.validate(email)) {
			throw new ValidateException("Email is invalid");
		}
		if(StringUtils.isBlank(name)) {
			throw new ValidateException("Name is required");
		}
		if(StringUtils.isBlank(text)) {
			throw new ValidateException("Text is required");
		}
	}
}
