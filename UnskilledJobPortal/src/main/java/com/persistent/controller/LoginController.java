package com.persistent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.persistent.service.UsersService;

@Controller
public class LoginController {

	public static HttpSession session;
	
	@Autowired
	private UsersService service;
	
	@GetMapping("/login/{aadhar}")
	public String login(HttpServletRequest request,@PathVariable String aadhar)
	{
		
		
		session=request.getSession();
		session.setAttribute("userId", service.getIdByAadhar(aadhar));
		System.out.println("login called"+session.getAttribute("userId"));
		return "redirect:/all_job_list";
	}
	
	@GetMapping("/login")
	public String login(HttpServletRequest request)
	{
		session=request.getSession();
		session.setAttribute("user_aadhar", 1);
		System.out.println("logged user...."+session.getAttribute("userId"));
		
		return "all_job_list";
	}
	
	//not-required methods......
	@GetMapping("/all_job_list")
	public String all_job_list()
	{
		return "all_job_list";
	}
	
	@GetMapping("/dashboard")
	public String dashboard()
	{
		return "dashboard";
	}
	
	@GetMapping("/job_post")
	public String postJob()
	{
		return "job_post";
	}
	
	@GetMapping("/apply_job")
	public String applyJob()
	{
		return "apply_job";
	}
	
}
