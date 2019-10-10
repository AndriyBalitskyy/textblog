package com.vpodobano.textblog.exception;

public class RedirectToValidUrlException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 257584097383389206L;

	private String url;

	public RedirectToValidUrlException(String url) {
		super("Should be redirect to " + url);
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
}
