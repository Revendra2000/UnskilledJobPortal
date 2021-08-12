package com.persistent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IAllAppliedJobDAO;
import com.persistent.dao.IJobDAO;
import com.persistent.entity.JobDetails;

@Service("jobService")
public class JobService {
	
	@Autowired
	private IJobDAO dao;
	
	@Autowired
	private IAllAppliedJobDAO appliedDao;
	
	@Autowired
	private UsersService userService;
	
	public JobDetails getJobDetailsById(int id)
	{
		return dao.findByJobId(id);
	}
	
	public List<JobDetails> jobsAppliedByWorkerById(int userId)
	{
		
		Set<Integer> id_list=appliedDao.jobsAppliedByWorkerById(userService.getAahdarById(userId));
		List<JobDetails> jobs=new ArrayList<JobDetails>();
		
		for(int id:id_list)
		{
			JobDetails j=new JobDetails();
			j=dao.findByJobId(id);
			jobs.add(j);
		}		
		return jobs;
	}
	
	public String getStatusofJob(int jobId,int userId)
	{
		JobDetails job=dao.findByJobId(jobId);
		if(!job.isActive())
		{
			return "rejected";
		}
		String aadhar=userService.getAahdarById(userId);
		if(job.getJobAssignedTo()==null)
		{
			return "pending";
		}
		else if(job.getJobAssignedTo()==aadhar)
		{
			return "accepted";
		}
		else 
			return "rejected";
	}

//from home page branch
	public List<JobDetails> getAllJobs() {
		return dao.getAllJobs();
	}
}
