package com.lvq.bookArchive.domain;

import javax.validation.constraints.*;

public class Book {
//	(`ID`, `Author`, `Title`, `Year`, `Publisher`, `image`)
//	8, 'Doug Lowe', 'Java All-In-One for Dummies', 2016, 4, 'Java All-In-One for Dummies.jpg'),
	private int id;
	
	@Size(min=2, message="{validation.Book.author}")
	private String author;
	
	@Size(min=2, message="Title name length must be longer than 1 letter")
	private String title;
	
	@Min(value = 1000, message="{validation.Book.year}")
	private int year;
	
	//@NotNull(message="Publisher must not be null")
	private int publisher;
	
	//@NotNull(message="Image must not be null")
	private String image;
	
	public Book() {
		super();
	}
	
	public Book(int id, String author, String title, int year, int publisher, String image) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.year = year;
		this.publisher = publisher;
		this.image = image;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPublisher() {
		return publisher;
	}
	public void setPublisher(int publisher) {
		this.publisher = publisher;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
