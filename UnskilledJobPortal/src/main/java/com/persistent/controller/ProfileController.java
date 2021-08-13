package com.persistent.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.persistent.entity.JobDetails;
import com.persistent.service.CategoryService;
import com.persistent.service.JobService;
import com.persistent.service.UsersService;

@Controller
public class ProfileController {
	
		@Autowired
		private JobService jobService;
		@Autowired
		private UsersService userService;
		@Autowired
		private CategoryService catService;
		
		@PostMapping(value="/profile")
		public String showAllJobs() {
			
			return "/all_job_list";
		}
	
		@GetMapping(value="/profile")
		public String showDashBoard(Model m,HttpSession session) {
			
			if(LoginController.session==null)
				return "redirect:login";
			
			m.addAttribute("alljobs",jobService.getAllJobs());
			return "/dashboard";
		}
		
		@GetMapping(value="/profile")
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
		
		//@GetMapping(value="/profile")
		//public String showEditProfile() {
			
		//	return "/profile_edit";
		//}
		

}
