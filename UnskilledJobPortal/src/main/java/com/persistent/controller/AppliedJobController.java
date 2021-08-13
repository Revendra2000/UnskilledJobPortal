package com.persistent.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
//Receive request to show a job in detail
	@RequestMapping(value="/Apply_job",method=RequestMethod.POST)
	public String Apply_job(@RequestParam(name="desc", required=false) String desc,
			@RequestParam(name="state", required=false) String state,
			@RequestParam(name="city", required=false) String city,
			@RequestParam(name="pin", required=false) String pin,
			@RequestParam(name="area", required=false) String area,
			@RequestParam(name="cost", required=false) String cost,
			@RequestParam(name="type", required=false) String type,
			@RequestParam(name="date", required=false) String date,
			@RequestParam(name="id", required=false) String id,Model m) {
			
	
		if(LoginController.session==null)
			return "redirect:/login";
		
		m.addAttribute("desc", desc);
		m.addAttribute("state", state);
		m.addAttribute("city", city);
		m.addAttribute("pin", pin);
		m.addAttribute("area", area);
		m.addAttribute("cost", cost);
		m.addAttribute("type", type);
		m.addAttribute("date", date);
		m.addAttribute("id",id);
		return "apply_job";
	}
	

//will receive request to apply For a job and redirect to "All Applied Jobs" Page	
	@GetMapping("/jobApplied/{job_id}")
	public String applyJob(@PathVariable String job_id,HttpSession session,Model model)
	{
		if(LoginController.session==null)
			return "redirect:/login";
		
		int id=Integer.parseInt(job_id);
		
		appliedJobService.applyJob(id,(int) session.getAttribute("userId"));

		return "redirect:/all_applied_jobs";
	}
	
	
//will show list of all jobs which logged user has applied for
	@GetMapping("/all_applied_jobs")
	public String viewMyAppliedJob(Model model,HttpSession session)
	{		
		if(LoginController.session==null)
			return "redirect:/login";
		
		
		List<AppliedJobDetails> jobDetails=new ArrayList<AppliedJobDetails>();
		
		List<JobDetails> jobsAppled=jobService.jobsAppliedByWorkerById((int) session.getAttribute("userId"));
		
//------------------Merging details ofLogged User, his applied Jobs, Job details, and Details of Job owner-------------//
		
		for(JobDetails jobs:jobsAppled)
		{
			AppliedJobDetails detail=new AppliedJobDetails();
			detail.setOwner(userService.getNameById((int) session.getAttribute("userId")));
			
			
			detail.setAadhar(userService.getUserAadharUsingUserId((int) session.getAttribute("userId")));
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
