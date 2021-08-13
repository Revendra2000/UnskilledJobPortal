package com.persistent.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.persistent.entity.JobDetails;

public interface IJobDAO extends CrudRepository<JobDetails, Integer> {

 
	JobDetails findByJobId(int id);

	@Query("Select * from JobDetails where is_active = 'T' ")
	JobDetails getAllJobs();

	

}