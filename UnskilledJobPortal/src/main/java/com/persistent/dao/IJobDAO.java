package com.persistent.dao;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entity.JobDetails;

public interface IJobDAO extends CrudRepository<JobDetails, Integer> {

}
