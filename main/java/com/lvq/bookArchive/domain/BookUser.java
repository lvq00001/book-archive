package com.lvq.bookArchive.domain;

import javax.validation.constraints.*;

public class BookUser {
	
	private int id;
	
	@Size(min=5, max=15, message="{validation.BookUser.username}")
	private String username;
	
	@Size(min=6, message="{validation.BookUser.password}")
	private String user_password;
	
	private String user_role;
	
	public BookUser() {
		super();
	}
	
	public BookUser(int id, String username, String user_password, String user_role) {
		super();
		this.id = id;
		this.username = username;
		this.user_password = user_password;
		this.user_role = user_role;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	
	
	
}
