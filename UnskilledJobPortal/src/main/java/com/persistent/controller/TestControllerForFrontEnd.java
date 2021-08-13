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
		
		@RequestMapping(value="/profile",method=RequestMethod.GET)
		public String profile() {
			if(LoginController.session==null)
				return "redirect:/login";
			
			return "profile";
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

