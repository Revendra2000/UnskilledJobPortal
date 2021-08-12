package com.persistent.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.persistent.entity.JobDetails;

public interface IJobDAO extends CrudRepository<JobDetails,Integer> {

	JobDetails findByJobId(int id);
	
	

}
