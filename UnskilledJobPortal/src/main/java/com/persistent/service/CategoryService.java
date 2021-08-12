package com.persistent.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.ICategoryDAO;
import com.persistent.entity.Category;

@Service("categoryService")
public class CategoryService {

	@Autowired
	private ICategoryDAO dao;
	
	public String getCategoryById(int id)
	{
		return dao.findByCategoryId(id).getCategoryName();
	}
	
	public void addCategory()
	{
		dao.insertCategory(12,"Lightman");
	}
	
}
