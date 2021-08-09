package com.persistent.dao;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entity.All_Applied_Jobs;

public interface IApliedJobsDAO extends CrudRepository<All_Applied_Jobs, Integer> {

}
