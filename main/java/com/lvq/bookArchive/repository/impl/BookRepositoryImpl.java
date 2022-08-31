package com.lvq.bookArchive.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lvq.bookArchive.domain.Book;
import com.lvq.bookArchive.domain.Publisher;
import com.lvq.bookArchive.repository.BookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	private static final class BookMapper implements RowMapper<Book> {
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book b = new Book();
			b.setId(rs.getInt("ID"));
			b.setAuthor(rs.getString("Author"));
			b.setTitle(rs.getString("Title"));
			b.setYear(rs.getInt("Year"));
			b.setPublisher(rs.getInt("Publisher"));
			b.setImage(rs.getString("image"));
			//System.out.println(rs.getString("Title"));
			return b;
		}
	}

	public List<Book> getAllBooks() {
		String sql = "SELECT * FROM books order by id";
		List<Book> rs = jdbcTemplate.query(sql, new BookMapper());
		return rs;
	}
	private static final class PublisherMapper implements RowMapper<Publisher> {
		public Publisher mapRow(ResultSet rs, int rowNum) throws SQLException {
			Publisher p = new Publisher();
			p.setPublisherID(rs.getInt("id"));
			p.setPublisher(rs.getString("publisher"));
			return p;
		}
	}

	public List<String> getListOfPublisherFromBook(List<Book> listOfBook) {
		String sql = "select * from publisher order by id";
		List<Publisher> listOfPublisher = jdbcTemplate.query(sql, new PublisherMapper());
		
		String[] arr = new String[listOfPublisher.size()];
		int index = 0;
		for (Publisher p : listOfPublisher) {
			arr[index] = p.getPublisher();
			index++;
		}
		List<String> rs = new ArrayList<String>();
		for (Book b : listOfBook) {
			rs.add(arr[b.getPublisher()-1]);
		}
		return rs;
	}
	
	public List<Book> findBooks(String name) {
		String sql = "select * from books where title like '%"+name+"%'"
				+ "union "
				+ "select * from books where author like '%"+name+"%'";
		List<Book> rs = jdbcTemplate.query(sql, new BookMapper());
		return rs;
	}

	public void addBook(Book book) {
		String sql = "insert into books (id, author, title, year, publisher, image) values (:id, :author, :title, :year, :publisher, :image)";
		Map<String, Object> param = new HashMap<>();
		param.put("id", book.getId());
		param.put("author", book.getAuthor());
		param.put("title", book.getTitle());
		param.put("year", book.getYear());
		param.put("publisher", book.getPublisher());
		param.put("image", book.getImage());
		namedJdbcTemplate.update(sql, param);
		
	}

	@Override
	public Book getBookById(int id) {
		String sql = "select * from books where id = :id";
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		Book book = namedJdbcTemplate.queryForObject(sql, param, new BookMapper());
		return book;
	}

	@Override
	public void updateBook(Book book) {
		deleteBook(book.getId());
		addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		String sql = "delete from books where id = :id";
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		namedJdbcTemplate.update(sql, param);
	}


}









