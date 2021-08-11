package com.persistent.dao;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entity.Category;

public interface ICategoryDAO extends CrudRepository<Category, Integer> {

}
