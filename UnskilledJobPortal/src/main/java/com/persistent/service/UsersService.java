package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IUsersDAO;
import com.persistent.entity.Users;

@Service("usersService")
public class UsersService {

	@Autowired
	private IUsersDAO dao;
	
	Users getUserByAadharNo(String aadharNo)
	{
		return dao.findByAadhar(aadharNo);
	}
}
