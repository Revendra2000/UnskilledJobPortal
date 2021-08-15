
package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IUsersDAO;
import com.persistent.entity.Users;

@Service("usersService")
public class UsersService {

	@Autowired
	private IUsersDAO dao;
	
	public Users registerUser(Users u)
	{
		//changed return dao.save(u) because userId is autogenerated so custom query is required
//		int result= dao.insertUserDetails(u.getAadhar(), u.getAddress(), u.getContact(), u.getFirstName(), u.getGender(), u.getLastName(), u.getPassword(), u.getRoles());
//		if(result==1)
//		{
//			return dao.findByAadhar(u.getAadhar());
//		}
//		else
//			return new Users();
		return dao.save(u);
	
	}
	
	public Users getUserByAadharNo(String aadharNo)
	{
		return dao.findByAadhar(aadharNo);
	}
	
	public String getUserAadharUsingUserId(int userId)
	{
		return dao.findAadharByUserId(userId);
	}
	
	//for appliedJobController to fetch name of logged users
	public String getNameById(int id)
	{
		System.out.println("User id "+id);
		Users u=dao.findByUserId(id);		
		return u.getFirstName()+" "+u.getLastName();
	}

	
	
}
