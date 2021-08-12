package com.persistent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.persistent.entity.AllAppliedJob;

public interface IAllAppliedJobDAO extends CrudRepository<AllAppliedJob, Integer> {

	@Query("select a.aadharWorker from AllAppliedJob a where a.jobId=?1")
	List<String> findAllUserAadhar(@Param("jobId")Integer jobId);
	
}
