package com.persistent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	

	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signup() {
		return "signup";
	}
	
	@RequestMapping(value="/homepage",method=RequestMethod.GET)
	public String homepage() {
		return "homepage";
	}
	
	@RequestMapping(value={"/dashboard","/"},method=RequestMethod.GET)
	public String dashboard() {
		return "dashboard";
	}
	
	@RequestMapping(value="/job_post",method=RequestMethod.GET)
	public String job_post() {
		return "job_post";
	}
	
	@RequestMapping(value="/posted_job_list",method=RequestMethod.GET)
	public String posted_job_list() {
		return "posted_job_list";
	}
	
	@RequestMapping(value="/job_applied_list",method=RequestMethod.GET)
	public String job_applied_list() {
		return "job_applied_list";
	}
	
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public String profile() {
		return "profile";
	}
	
	@RequestMapping(value="/all_applied_jobs",method=RequestMethod.GET)
	public String all_applied_jobs() {
		return "all_applied_jobs";
	}
	
	@RequestMapping(value="/all_job_list",method=RequestMethod.GET)
	public String all_job_list() {
		return "all_job_list";
	}
	
	@RequestMapping(value="/Apply_job",method=RequestMethod.GET)
	public String Apply_job() {
		return "Apply_job";
	}
//	@RequestMapping(value="/admin_login",method=RequestMethod.GET)
//	public String admin_login() {
//		return "admin_login";
//	}
	

}
