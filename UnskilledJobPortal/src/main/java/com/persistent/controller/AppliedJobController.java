package com.persistent.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.persistent.service.All_Applied_JobsService;
import com.persistent.service.JobService;

@Controller
public class AppliedJobController {

	@Autowired
	private JobService job_service;
	
	@Autowired
	private All_Applied_JobsService applied_job_service;
	
	//HttpSession session=LoginController.session;
	
	
	
	@GetMapping("viewJob/{id}")
	public String getJobDetailsById(@PathVariable int id,Model model,HttpSession session)//, Model model)
	{
		if(session==null)
			return "login";
		
		System.out.println("called..1");
		//model.addAttribute("detailed_job",service.getJobDetailsById(id));
		//return "viewDetails";
		
		System.out.println(job_service.getJobDetailsById(id));
		model.addAttribute("job", job_service.getJobDetailsById(id));
		return "Apply_job";
	}
	
	@GetMapping("viewJob/Apply_job/{job_id}")
	public String applyJob(@PathVariable int job_id,HttpSession session,Model model)
	{
		if(LoginController.session==null)
			return "login";
		System.out.println("called..2");
		applied_job_service.applyJob(job_id,(String)session.getAttribute("user_aadhar"));
		model.addAttribute("jobList", job_service.jobsAppliedByWorkerById((String) session.getAttribute("user_aadhar")));
		System.out.println(model.getAttribute("jobList"));
		return "all_applied_jobs";
	}
	
	@GetMapping("viewJob/Apply_job/all_applied_jobs")
	public String viewMyAppliedJob(Model model,HttpSession session)
	{
		if(LoginController.session==null)
			return "login";
		
		System.out.println("called....3");
		model.addAttribute("jobList", job_service.jobsAppliedByWorkerById((String) session.getAttribute("user_aadhar")));
		System.out.println(model.getAttribute("jobList"));
		return "all_applied_jobs";
	}
	
}
