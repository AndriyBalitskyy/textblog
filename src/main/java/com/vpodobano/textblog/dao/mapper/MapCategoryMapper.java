package com.vpodobano.textblog.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.RowProcessor;

import com.vpodobano.textblog.entity.Category;

public class MapCategoryMapper implements ResultSetHandler<Map<Long, Category>> {
	private RowProcessor convert = new BasicRowProcessor();
	
	@Override
	public Map<Long, Category> handle(ResultSet rs) throws SQLException {
		Map<Long, Category> map = new HashMap<>();
		while(rs.next()) {
			Category category = convert.toBean(rs, Category.class);
			map.put(category.getId(), category);
		}
		return map;
	}
	
}
