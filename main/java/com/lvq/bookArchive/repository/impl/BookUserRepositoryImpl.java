package com.lvq.bookArchive.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lvq.bookArchive.domain.BookUser;
import com.lvq.bookArchive.repository.BookUserRepository;

@Repository
public class BookUserRepositoryImpl implements BookUserRepository{

	@Autowired
	NamedParameterJdbcTemplate NP_JdbcTemplate;
	
	@Override
	public BookUser getUserByUsername(String username) {
		String sql = "select * from book_user where username = :username";
		Map<String, Object> param = new HashMap<>();
		param.put("username", username);
		BookUser bu;
		try {
			bu = NP_JdbcTemplate.queryForObject(sql, param, new BookUserMapper());
		} catch (Exception e) {
			return null;
		}
		return bu;
	}
	
	private static final class BookUserMapper implements RowMapper<BookUser> {
		@Override
		public BookUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookUser bu = new BookUser();
			bu.setId(rs.getInt("id"));
			bu.setUser_password(rs.getString("user_password"));
			bu.setUser_role(rs.getString("user_role"));
			bu.setUsername(rs.getString("username"));
			return bu;
		}
		
	}

	@Override
	public void saveUser(BookUser bu) {
		String sql = "insert into book_user (username, user_password) values (:username, :user_password)";
		Map<String, Object> param = new HashMap<>();
		param.put("username", bu.getUsername());
		param.put("user_password", bu.getUser_password());
		NP_JdbcTemplate.update(sql, param);
	}
	
}
