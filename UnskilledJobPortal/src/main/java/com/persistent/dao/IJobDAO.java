package com.persistent.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.persistent.entity.Job;

public interface IJobDAO extends CrudRepository<Job,String> {

	Job findByJobId(int id);
	
	@Query("select a.job_id from All_Applied_Jobs a where  a.aadhar_worker= :aadhar")
	Set<Integer> jobsAppliedByWorkerById(@Param("aadhar") String aadhar);
	
}
