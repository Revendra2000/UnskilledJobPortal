package com.persistent.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.persistent.dao.IJobDAO;
import com.persistent.service.CategoryService;

@Controller
public class TestControllerForFrontEnd {
	
	
	@Autowired
	private IJobDAO dao;
	
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
		

		@RequestMapping(value="/profile",method=RequestMethod.GET)
		public String profile() {
			if(LoginController.session==null)
				return "redirect:/login";
			
			return "profile";
		}
//		
//		@RequestMapping(value="/homepage",method=RequestMethod.GET)
//		public String homepage() {
//			return "homepage";
//		}
//		
//		@RequestMapping(value={"/dashboard","/"},method=RequestMethod.GET)
//		public String dashboard(Model m) {
//			m.addAttribute("allJobs",dao.getAllJobs());
//			return "dashboard";
//		}
//		
//		@RequestMapping(value="/job_post",method=RequestMethod.GET)
//		public String job_post() {
//			return "job_post";
//		}
//		
//		@RequestMapping(value="/posted_job_list",method=RequestMethod.GET)
//		public String posted_job_list() {
//			return "posted_job_list";
//		}
//		
//		@RequestMapping(value="/job_applied_list",method=RequestMethod.GET)
//		public String job_applied_list() {
//			return "job_applied_list";
//		}
//		
//		
//		//@RequestMapping(value="/all_applied_jobs",method=RequestMethod.GET)
//		public String all_applied_jobs() {
//			return "all_applied_jobs";
//		}
//		
//		//@RequestMapping(value="/all_job_list",method=RequestMethod.GET)
//		public String all_job_list() {
//			return "all_job_list";
//		}
		
		
	
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
			
			System.out.println("nazmin controller working");
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
		
		
		
		@Autowired
		private CategoryService catDao;
		@GetMapping(value="/addCategory")
		public String addCategory1()
		{
			catDao.addCategory();
			return "all_job_list";
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

