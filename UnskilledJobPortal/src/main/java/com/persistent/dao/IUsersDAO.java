package com.persistent.dao;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entity.Users;

public interface IUsersDAO extends CrudRepository<Users, String> {

}
