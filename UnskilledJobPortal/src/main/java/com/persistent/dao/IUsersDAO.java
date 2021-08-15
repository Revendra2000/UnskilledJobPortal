package com.persistent.dao;

import java.sql.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.persistent.entity.Users;

public interface IUsersDAO extends CrudRepository<Users, String> {

	@Query(value="SELECT * FROM users WHERE Aadhar_No = ?", nativeQuery = true)
	  Users findByAadhar(String aadharNo);
	
	@Query(value="SELECT aadhar_no FROM users WHERE user_id = ?", nativeQuery = true)
	  String findAadharByUserId(int userId);

	Users findByUserId(int id);
	
	
	
	@Modifying
	@Transactional
	@Query(value = "insert into users (aadhar_no, address, contact, first_name, gender, last_name, password, roles) values (?, ?, ?, ?, ?, ?, ?, ?, ?) ", nativeQuery = true)
		int insertUserDetails(String aadharNo,String address,String contact,String firstName,String gender,String lastName,String password,String roles);

}
