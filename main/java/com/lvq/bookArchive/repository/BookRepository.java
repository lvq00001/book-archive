package com.lvq.bookArchive.repository;

import java.util.List;

import com.lvq.bookArchive.domain.Book;

public interface BookRepository {
	List<Book> getAllBooks();

	List<Book> findBooks(String name);

	void addBook(Book book);

	Book getBookById(int id);

	void updateBook(Book book);
	
	void deleteBook(int id);
	
	public List<String> getListOfPublisherFromBook(List<Book> listOfBook);
	
}
