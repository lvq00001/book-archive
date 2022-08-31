package com.lvq.bookArchive.domain;

import javax.validation.constraints.NotNull;

public class Publisher {
	
	private int publisherID;
	
	@NotNull(message="{validation.Publisher.publisher}")
	private String publisher;
	
	public Publisher() {
		super();
	}

	public Publisher(int publisherID, String publisher) {
		super();
		this.publisherID = publisherID;
		this.publisher = publisher;
	}
	
	public int getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(int publisherID) {
		this.publisherID = publisherID;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	
}
