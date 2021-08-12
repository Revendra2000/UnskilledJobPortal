package com.persistent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.persistent.entity.JobDetails;

public interface IJobDAO extends CrudRepository<JobDetails, Integer> {

	@Query(value="SELECT * FROM JOB_DETAILS WHERE is_active='T'",nativeQuery=true)
	public List<JobDetails> getAllJobs();
}
