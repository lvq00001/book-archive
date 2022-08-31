package com.lvq.bookArchive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvq.bookArchive.domain.Book;
import com.lvq.bookArchive.repository.BookRepository;
import com.lvq.bookArchive.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.getAllBooks();
	}

	@Override
	public List<Book> findBooks(String name) {
		// TODO Auto-generated method stub
		return bookRepository.findBooks(name);
	}

	@Override
	public void addBook(Book book) {
		bookRepository.addBook(book);
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return bookRepository.getBookById(id);
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.updateBook(book);
	}
	

	@Override
	public void deleteBook(int id) {
		bookRepository.deleteBook(id);
	}

	@Override
	public List<String> getListOfPublisherFromBook(List<Book> listOfBook) {
		return bookRepository.getListOfPublisherFromBook(listOfBook);
	}

}
