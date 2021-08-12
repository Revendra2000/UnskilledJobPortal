package com.persistent.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.persistent.entity.Users;

public interface IUsersDAO extends CrudRepository<Users, String> {


	Users findByUserId(int id);
	
	@Query(value="select u from Users u where u.aadharNo=:aadhar")
	Users getUserByAadhar(@Param("aadhar") String aadhar);
	
	
}
