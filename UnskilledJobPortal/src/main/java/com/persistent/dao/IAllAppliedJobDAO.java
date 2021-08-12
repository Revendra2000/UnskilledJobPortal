package com.persistent.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.persistent.entity.AllAppliedJob;

public interface IAllAppliedJobDAO extends CrudRepository<AllAppliedJob, Integer> {

	@Query("select a.jobId from AllAppliedJob a where  a.aadharWorker= :aadhar")
	Set<Integer> jobsAppliedByWorkerById(@Param("aadhar") String aadhar);
	
	
}
