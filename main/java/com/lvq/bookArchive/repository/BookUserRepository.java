package com.lvq.bookArchive.repository;

import com.lvq.bookArchive.domain.BookUser;


public interface BookUserRepository {
	public BookUser getUserByUsername(String username);

	public void saveUser(BookUser bu);
	
}
