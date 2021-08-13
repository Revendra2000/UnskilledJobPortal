package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IUsersDAO;
import com.persistent.entity.Users;

@Service("usersService")
public class UsersService {

	@Autowired
	private IUsersDAO dao;
	
	public Users getUserByAadharNo(String aadharNo)
	{
		return dao.findByAadhar(aadharNo);
	}
	
	public String getUserAadharUsingUserId(int userId)
	{
		return dao.findAadharByUserId(userId);
	}


	public String getAahdarById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
