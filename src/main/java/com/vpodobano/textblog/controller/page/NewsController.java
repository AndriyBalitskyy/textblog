package com.vpodobano.textblog.controller.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vpodobano.textblog.Constants;
import com.vpodobano.textblog.controller.AbstractController;
import com.vpodobano.textblog.entity.Article;
import com.vpodobano.textblog.entity.Category;
import com.vpodobano.textblog.model.Items;
import com.vpodobano.textblog.model.Pagination;

@WebServlet({"/news", "/news/*"})
public class NewsController extends AbstractController {

	private static final long serialVersionUID = 4533299780113097220L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int offset = getOffset(req, Constants.LIMIT_ARTICLES_PER_PAGE);
		String requestUrl = req.getRequestURI();
		Items<Article> items = null;
		if (requestUrl.endsWith("/news") || requestUrl.endsWith("/news/")) {
			items = getBusinessService().listArticles(0, Constants.LIMIT_ARTICLES_PER_PAGE);
			req.setAttribute("isNewPage", Boolean.TRUE);
		} else {
			String categoryUrl = requestUrl.replace("/news", "");
			Category category = getBusinessService().findCategoryByUrl(categoryUrl);
			if (category == null) {
				resp.sendRedirect("/404?url=" + requestUrl);
				return;
			} 
			items = getBusinessService().listArticlesByCategory(categoryUrl, offset, Constants.LIMIT_ARTICLES_PER_PAGE);
			req.setAttribute("selectedCategory", category);
		}
		
		req.setAttribute("list", items.getItems());
		Pagination pagination = new Pagination.Builder(requestUrl + "?", offset, items.getCount()).withLimit(Constants.LIMIT_ARTICLES_PER_PAGE).build();
		req.setAttribute("pagination", pagination);
		forwardToPage("news.jsp", req, resp);
	}
}
