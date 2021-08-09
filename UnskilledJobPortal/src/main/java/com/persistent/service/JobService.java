package com.persistent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IJobDAO;
import com.persistent.entity.Job;

@Service
public class JobService {
	
	@Autowired
	private IJobDAO dao;
	
	public Job getJobDetailsById(int id)
	{
		return dao.findByJobId(id);
	}
	
	public List<Job> jobsAppliedByWorkerById(String aadhar_worker)
	{
		Set<Integer> id_list=dao.jobsAppliedByWorkerById(aadhar_worker);
		List<Job> jobs=new ArrayList<Job>();
		
		for(int id:id_list)
		{
			Job j=new Job();
			j=dao.findByJobId(id);
			jobs.add(j);
		}		
		return jobs;
	}

	
}
