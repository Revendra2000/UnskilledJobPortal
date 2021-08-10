package com.persistent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LoginController {

	public static HttpSession session;
	
	@GetMapping("/login/{id}")
	public String login(HttpServletRequest request,@PathVariable String id)
	{
		session=request.getSession();
		session.setAttribute("user_aadhar", id);
		System.out.println("login called");
		return "all_job_list";
	}
	
	@GetMapping("/login")
	public String login(HttpServletRequest request)
	{
		session=request.getSession();
		session.setAttribute("user_aadhar", "123");
		System.out.println("logged user...."+session.getAttribute("user_aadhar"));
		
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
