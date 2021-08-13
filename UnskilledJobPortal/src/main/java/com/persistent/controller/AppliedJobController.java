package com.persistent.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.persistent.entity.AppliedJobDetails;
import com.persistent.entity.JobDetails;
import com.persistent.service.AllAppliedJobService;
import com.persistent.service.CategoryService;
import com.persistent.service.JobService;
import com.persistent.service.UsersService;

@Controller
public class AppliedJobController {

	@Autowired
	private JobService jobService;
	
	@Autowired
	private AllAppliedJobService appliedJobService;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private CategoryService catService;
	

//	@GetMapping("applyJob/{jobId}")
//	public String getJobDetailsById(@PathVariable String jobId,Model model,HttpSession session)//, Model model)
//	{
//		if(session==null)
//			return "login";
//		
//		System.out.println(jobId);
//		
//		int id=Integer.parseInt(jobId);
//		
//		model.addAttribute("jobs", jobService.getJobDetailsById(id));
//		System.out.println("view this job..."+model.getAttribute("jobs"));
//		return "apply_job";
//	}
	
	@GetMapping("/jobApplied/{job_id}")
	public String applyJob(@PathVariable String job_id,HttpSession session,Model model)
	{
		if(LoginController.session==null)
			return "redirect:/login";
		
		int id=Integer.parseInt(job_id);
		
		appliedJobService.applyJob(id,(int) session.getAttribute("userId"));

		return "redirect:/all_applied_jobs";
	}
	
	
	@GetMapping("/all_applied_jobs")
	public String viewMyAppliedJob(Model model,HttpSession session)
	{		
		if(LoginController.session==null)
			return "redirect:/login";
		
		
		List<AppliedJobDetails> jobDetails=new ArrayList<AppliedJobDetails>();
		
		List<JobDetails> jobsAppled=jobService.jobsAppliedByWorkerById((int) session.getAttribute("userId"));		
		for(JobDetails jobs:jobsAppled)
		{
			AppliedJobDetails detail=new AppliedJobDetails();
			detail.setOwner(userService.getNameById((int) session.getAttribute("userId")));
			detail.setAadhar(userService.getAahdarById((int) session.getAttribute("userId")));
			detail.setDateOfPost(jobs.getDateOfPost());
			detail.setJobId(jobs.getJobId());
			detail.setCategory(catService.getCategoryById(jobs.getCategoryId()));
			detail.setStatus(jobService.getStatusofJob(jobs.getJobId(), (int) session.getAttribute("userId")));
			detail.setLocation(jobs.getWorkArea()+" , "+jobs.getWorkCity()+" , "+jobs.getWorkState());
			
			jobDetails.add(detail);
		}
		model.addAttribute("jobList", jobDetails);
		System.out.println(model.getAttribute("jobList"));
		return "all_applied_jobs";
	}
	
}
