package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.persistent.dao.IUsersDAO;

public class UsersService {

	@Autowired
	private IUsersDAO dao;
	
}
