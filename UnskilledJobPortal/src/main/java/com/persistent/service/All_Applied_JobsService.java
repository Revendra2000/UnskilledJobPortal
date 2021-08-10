package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IApliedJobsDAO;
import com.persistent.entity.All_Applied_Jobs;

@Service
public class All_Applied_JobsService {

	@Autowired
	private IApliedJobsDAO dao;
	
	public void applyJob(int job_id,String aadhar)
	{
		All_Applied_Jobs job=new All_Applied_Jobs();
		job.setJob_id(job_id);
		job.setAadhar_worker(aadhar);
		System.out.println(job);
		dao.save(job);
	}
	
	
}
