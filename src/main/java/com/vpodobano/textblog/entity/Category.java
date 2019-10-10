package com.vpodobano.textblog.entity;

public class Category extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5810195839461503939L;

	private String name;
	private String url;
	private int articles;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getArticles() {
		return articles;
	}
	public void setArticles(int articles) {
		this.articles = articles;
	}
}
