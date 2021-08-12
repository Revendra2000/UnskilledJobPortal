package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.ICategoryDAO;

@Service("categoryService")
public class CategoryService {

	@Autowired
	private ICategoryDAO dao;
	
}
