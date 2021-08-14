package com.persistent.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persistent.entity.Categories;
import com.persistent.entity.Users;

public interface IUserDao extends CrudRepository<Users, String>{
	 List<Users> findAll();
}
