package com.persistent.dao;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entity.Job;

public interface IJobDAO extends CrudRepository<Job, Integer> {

}
