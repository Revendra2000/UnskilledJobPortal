
package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IAdminDAO;

@Service
public class AdminService {

	@Autowired
	private IAdminDAO dao;
	
}
