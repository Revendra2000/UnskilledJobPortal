package com.persistent.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persistent.entity.Categories;



@Repository
public interface ICatDao extends CrudRepository<Categories,Integer> 
    
{
    //Categories findById(int category_id);
    List<Categories> findAll();
}