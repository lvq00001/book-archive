package com.lvq.bookArchive.service;

import java.util.List;

import com.lvq.bookArchive.domain.Book;

public interface BookService {
	List<Book> getAllBooks();

	List<Book> findBooks(String name);

	void addBook(Book book);

	Book getBookById(int id);

	void updateBook(Book book);
	
	void deleteBook(int id);
	
	public List<String> getListOfPublisherFromBook(List<Book> listOfBook);
}
