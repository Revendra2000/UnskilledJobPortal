package com.persistent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persistent.entity.Admin;
import com.persistent.entity.Users;


@Repository
public interface IAdminDao extends CrudRepository<Admin, String>{
	
}
