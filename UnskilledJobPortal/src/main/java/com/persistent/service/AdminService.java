package com.persistent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.ICatDao;
import com.persistent.dao.IUserDao;
import com.persistent.entity.Categories;
import com.persistent.entity.Users;

@Service
public class AdminService {
	
	@Autowired
	private ICatDao dao;
	
	@Autowired
	private IUserDao uDao;
	

	public List<Categories> getCategories(){
		return (List<Categories>)dao.findAll();
	}
	
	public void deleteCategory(int category_id) {
		dao.deleteById(category_id);
	}
	
	public void addCategory(Categories c) {
		dao.save(c);
	}
//	public Categories getCategory(int category_id) {
//		return dao.findById(category_id).get();
//	}

	
	public List<Users> getUsers() {
		return (List<Users>)uDao.findAll();
	}
	public void deleteUser(String aadhar_no) {
		uDao.deleteById(aadhar_no);
	}
}
