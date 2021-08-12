
package com.persistent.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IUsersDAO;
import com.persistent.entity.Users;

@Service
public class UsersService {

	@Autowired
	private IUsersDAO dao;
	
	public String getNameById(int id)
	{
		Users u=dao.findByUserId(id);		
		return u.getFirstName()+" "+u.getLastName();
	}
	
	public int getIdByAadhar(String aadhar)
	{
		Users u=dao.getUserByAadhar(aadhar);	
		
		//Optional<Users> u=dao.findById(aadhar);
		return u.getUserId();
	}
	
	public String getAahdarById(int id)
	{
		Users u=dao.findByUserId(id);
		return u.getAadhar();
	}
	
}
