package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IAllAppliedJobDAO;
import com.persistent.dao.IUsersDAO;
import com.persistent.entity.AllAppliedJob;

@Service("allApplliedJobService")
public class AllAppliedJobService {

	@Autowired
	private IAllAppliedJobDAO dao;
	
	@Autowired
	private UsersService userService;
	
	public void applyJob(int job_id,int userId)
	{
		AllAppliedJob job=new AllAppliedJob();
		job.setjobId(job_id);
		job.setAadharWorker(userService.getAahdarById(userId));
		System.out.println(job);
		dao.save(job);
	}
	
}