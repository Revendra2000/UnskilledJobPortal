package com.persistent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestControllerForFrontEnd {
	
		@RequestMapping(value="/about_us",method=RequestMethod.GET)
		public String home() {
			return "about_us";
		}

		@RequestMapping(value="/login",method=RequestMethod.GET)
		public String login() {
			return "login";
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
			return "apply_job";
		}
		
		@RequestMapping(value="/admin_add_category",method=RequestMethod.GET)
		public String addCategory() {
			return "add_category";
		}
		
		@GetMapping("/admin_login")
		public String adminLogin() {
			return "admin_login";
		}
		
		@GetMapping("/admin_viewallcategory")
		public String viewAllCategory() {
			return "admin_viewallcategory";
		}
		@GetMapping("/admin_viewallusers")
		public String viewAllUsers() {
			return "admin_viewalluser";
		}
}

