package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.persistent.dao.IAdminDAO;

public class AdminService {

	@Autowired
	private IAdminDAO dao;
	
}
