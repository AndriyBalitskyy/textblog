package com.vpodobano.textblog.service;

import java.util.List;
import java.util.Map;

import com.vpodobano.textblog.entity.Article;
import com.vpodobano.textblog.entity.Category;
import com.vpodobano.textblog.entity.Comment;
import com.vpodobano.textblog.exception.RedirectToValidUrlException;
import com.vpodobano.textblog.exception.ValidateException;
import com.vpodobano.textblog.form.CommentForm;
import com.vpodobano.textblog.form.ContactForm;
import com.vpodobano.textblog.model.Items;

public interface BusinessService {
	Map<Long, Category> mapCategories();
	
	Items<Article> listArticles(int offset, int limit);
	
	Items<Article> listArticlesByCategory(String categoryUrl, int offset, int limit);
	
	Category findCategoryByUrl(String categoryUrl);
	
	Items<Article> listArticlesBySearchQuery(String searchQuery, int offset, int limit);
	
	Article viewArticle(Long idArticle, String requestUrl) throws RedirectToValidUrlException;
	
	List<Comment> listComments(Long idArticle, int offset, int limit);
	
	Comment createComment(CommentForm form) throws ValidateException;
	
	void createContactRequest(ContactForm form) throws ValidateException;
}
