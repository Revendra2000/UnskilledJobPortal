package com.persistent.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.persistent.entity.Category;

public interface ICategoryDAO extends CrudRepository<Category, Integer> {

	Category findByCategoryId(int id);
	
	@Modifying
	@Transactional
	@Query(value="insert into category(category_id,category_name) values(?1,?2)", nativeQuery = true)
	int insertCategory(int id,String category);
	
}
