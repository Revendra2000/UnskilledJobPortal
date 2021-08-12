package com.persistent.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

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
	

	@GetMapping("applyJob/{id}")
	public String getJobDetailsById(@PathVariable int id,Model model,HttpSession session)//, Model model)
	{
		if(session==null)
			return "login";
		
		model.addAttribute("jobs", jobService.getJobDetailsById(id));
		System.out.println("view this job..."+model.getAttribute("jobs"));
		return "apply_job";
	}
	
	@GetMapping("/jobApplied/{job_id}")
	public String applyJob(@PathVariable int job_id,HttpSession session,Model model)
	{
//		if(LoginController.session==null)
////			return "login";
		
		
		appliedJobService.applyJob(job_id,(int) session.getAttribute("userId"));
		
		
//		List<AppliedJobDetails> jobDetails=new ArrayList<AppliedJobDetails>();
//		
//		List<JobDetails> jobsAppled=jobService.jobsAppliedByWorkerById((int) session.getAttribute("userId"));		
//		for(JobDetails jobs:jobsAppled)
//		{
//			AppliedJobDetails detail=new AppliedJobDetails();
//			detail.setOwner(userService.getNameById((int) session.getAttribute("userId")));
//			detail.setAadhar(userService.getAahdarById((int) session.getAttribute("userId")));
//			detail.setDateOfPost(jobs.getDateOfPost());
//			detail.setJobId(jobs.getJobId());
//			detail.setCategory(catService.getCategoryById(jobs.getCategoryId()));
//			detail.setStatus(jobService.getStatusofJob(jobs.getJobId(), (int) session.getAttribute("userId")));
//			detail.setLocation(jobs.getWorkArea()+" , "+jobs.getWorkCity()+" , "+jobs.getWorkState());
//			
//			jobDetails.add(detail);
//		}
//		
//		
//		
//		model.addAttribute("jobList", jobDetails);
//		System.out.println(model.getAttribute("jobList"));
		
		return "redirect:/all_job_list";
	}
	
	@GetMapping("/all_applied_jobs")
	public String viewMyAppliedJob(Model model,HttpSession session)
	{
//		if(LoginController.session==null)
//			return "login";
//		
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
