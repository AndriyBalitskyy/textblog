package com.vpodobano.textblog.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.vpodobano.textblog.entity.Article;

public class ArticleMapper extends AbstractMapper<Article> {

	@Override
	public Article handleItem(ResultSet rs) throws SQLException {
		Article article = convert.toBean(rs, Article.class);
		article.setIdCategory(rs.getLong("id_category"));
		return article;
	}

}
