package com.lvq.bookArchive.service;

import com.lvq.bookArchive.domain.BookUser;

public interface BookUserService {
	public BookUser getUserByUsername(String username);

	public void saveUser(BookUser bu);
}
