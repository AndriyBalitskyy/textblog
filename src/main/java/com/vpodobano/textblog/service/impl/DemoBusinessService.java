package com.vpodobano.textblog.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;


import com.vpodobano.textblog.entity.Account;
import com.vpodobano.textblog.entity.Article;
import com.vpodobano.textblog.entity.Comment;
import com.vpodobano.textblog.exception.ApplicationException;
import com.vpodobano.textblog.exception.ValidateException;
import com.vpodobano.textblog.form.CommentForm;
import com.vpodobano.textblog.model.SocialAccount;

class DemoBusinessService extends BusinessServiceImpl {
	public DemoBusinessService(ServiceManager serviceManager) {
		super(serviceManager);
	}
	
	@Override
	public Comment createComment(CommentForm form) throws ValidateException {
		form.validate(i18nService);
		try (Connection c = dataSource.getConnection()) {
			SocialAccount socialAccount = socialService.getSocialAccount(form.getName(), form.getEmail(), form.getPhoto(), form.getAuthToken());
			Account account = new Account();
			account.setId(0L);
			account.setAvatar(socialAccount.getAvatar());
			account.setCreated(new Timestamp(System.currentTimeMillis()));
			account.setEmail(socialAccount.getEmail());
			account.setName(socialAccount.getName());
			Comment comment = new Comment(form.getIdArticle(), account, form.getContent(), new Timestamp(System.currentTimeMillis()));
			Article article = sql.findArticleForNewCommentNotification(c, form.getIdArticle());
			sendNewCommentNotification(article, form.getContent(), form.getLocale());
			return comment;
		} catch (SQLException e) {
			throw new ApplicationException("Can't create new comment: " + e.getMessage(), e);
		}
	}
}
