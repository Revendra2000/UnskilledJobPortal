package com.persistent.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.persistent.dao.IJobDAO;
import com.persistent.service.CategoryService;
import com.persistent.service.UsersService;

@Controller
public class TestControllerForFrontEnd {
	
	
	@Autowired
	private UsersService userService;
	
	
		@RequestMapping(value="/about_us",method=RequestMethod.GET)
		public String home(Principal principal) {
			
			//-----checking if session valid------//	
			if(principal==null)
				return "redirect:/login";
			else
				if(userService.getUserByAadharNo(principal.getName()).getRoles()=="admin")
					return "redirect:/login";
			
			int userId=userService.getUserByAadharNo(principal.getName()).getUserId();
			//---------session check over----------//
			
			return "about_us";
		}
		
		@RequestMapping(value="/profile",method=RequestMethod.GET)
		public String profile(Principal principal,Model model) {


			//-----checking if session valid------//	
			if(principal==null)
				return "redirect:/login";
			else
				if(userService.getUserByAadharNo(principal.getName()).getRoles()=="admin")
					return "redirect:/login";
			
			//---------session check over----------//
			model.addAttribute("user", userService.getUserByAadharNo(principal.getName()));
			
			return "profile";
		}
		
		@RequestMapping(value="/admin_add_category",method=RequestMethod.GET)
		public String addCategory(Principal principal) {
			
			//-----checking if session valid------//	
			if(principal==null)
				return "redirect:/login";
			else
				if(userService.getUserByAadharNo(principal.getName()).getRoles()=="admin")
					return "redirect:/login";
			
			int userId=userService.getUserByAadharNo(principal.getName()).getUserId();
			//---------session check over----------//
			
			return "add_category";
		}
		
		@GetMapping("/admin_login")
		public String adminLogin(Principal principal) {
			
			//-----checking if session valid------//	
			if(principal==null)
				return "redirect:/login";
			else
				if(userService.getUserByAadharNo(principal.getName()).getRoles()=="admin")
					return "redirect:/login";
			
			int userId=userService.getUserByAadharNo(principal.getName()).getUserId();
			//---------session check over----------//
			
			return "admin_login";
		}
		
		@GetMapping("/admin_viewallcategory")
		public String viewAllCategory(Principal principal) {
			
			//-----checking if session valid------//	
			if(principal==null)
				return "redirect:/login";
			else
				if(userService.getUserByAadharNo(principal.getName()).getRoles()=="admin")
					return "redirect:/login";
			
			int userId=userService.getUserByAadharNo(principal.getName()).getUserId();
			//---------session check over----------//
			
			return "admin_viewallcategory";
		}
		
		@GetMapping("/admin_viewallusers")
		public String viewAllUsers(Principal principal) {
			
			//-----checking if session valid------//	
			if(principal==null)
				return "redirect:/login";
			else
				if(userService.getUserByAadharNo(principal.getName()).getRoles()=="admin")
					return "redirect:/login";
			
			int userId=userService.getUserByAadharNo(principal.getName()).getUserId();
			//---------session check over----------//
			
			return "admin_viewalluser";
		}
}

