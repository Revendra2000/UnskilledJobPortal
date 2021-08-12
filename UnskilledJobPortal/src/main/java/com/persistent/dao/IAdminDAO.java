package com.persistent.dao;



import org.springframework.data.repository.CrudRepository;

import com.persistent.entity.Admin;

public interface IAdminDAO extends CrudRepository<Admin, String> {

}
