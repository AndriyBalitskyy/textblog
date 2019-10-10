package com.vpodobano.textblog.form;

import org.apache.commons.lang.StringUtils;

import com.vpodobano.textblog.exception.ValidateException;
import com.vpodobano.textblog.service.I18NService;

public class CommentForm extends AbstractForm {
	private Long idArticle;
	private String content;
	private String authToken;
	private String name;
	private String email;
	private String photo;
	public Long getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String phono) {
		this.photo = phono;
	}

	@Override
	public void validate(I18NService i18nService) throws ValidateException {
		if(idArticle == null) {
			throw new ValidateException("idArticle is required");
		}
		if(StringUtils.isBlank(content)) {
			throw new ValidateException("content is required");
		}
		if(StringUtils.isBlank(authToken)) {
			throw new ValidateException("authToken is required");
		}
		if(StringUtils.isBlank(name)) {
			throw new ValidateException("name is required");
		}
		if(StringUtils.isBlank(email)) {
			throw new ValidateException("email is required");
		}
		if(StringUtils.isBlank(photo)) {
			throw new ValidateException("photo is required");
		}
	}
		
}
