package com.persistent.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entity.Category;

public interface ICategoryDAO extends CrudRepository<Category, Integer> {
	
	List<Category> findAll();
	Category findById(int id);

}