package com.lvq.bookArchive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvq.bookArchive.domain.BookUser;
import com.lvq.bookArchive.repository.BookUserRepository;
import com.lvq.bookArchive.service.BookUserService;

@Service
public class BookUserServiceImpl implements BookUserService{

	@Autowired
	BookUserRepository bookUserRepository;
	
	@Override
	public BookUser getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return bookUserRepository.getUserByUsername(username);
	}

	@Override
	public void saveUser(BookUser bu) {
		bookUserRepository.saveUser(bu);
	}

}
