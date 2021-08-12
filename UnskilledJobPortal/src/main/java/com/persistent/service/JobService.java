package com.persistent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IJobDAO;
import com.persistent.entity.JobDetails;

@Service("jobService")
public class JobService {

	@Autowired
	private IJobDAO dao;
	
	public List<JobDetails> getAllJobs() {
		return dao.getAllJobs();
	}
}
