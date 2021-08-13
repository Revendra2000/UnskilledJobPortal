package com.persistent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.persistent.service.JobService;
import com.persistent.service.UsersService;

@Controller
public class LoginController {

	public static HttpSession session;
	
	@Autowired
	private UsersService service;
	
	@Autowired
	private JobService jobService;
	
	@GetMapping("/login/{aadhar}")
	public String login(HttpServletRequest request,@PathVariable String aadhar,Model m)
	{		
		
		session=request.getSession();
		session.setAttribute("userId", service.getIdByAadhar(aadhar));
		
		System.out.println("login called"+session.getAttribute("userId"));
		m.addAttribute("allJobs",jobService.getAllJobs());
		return "redirect:/dashboard";
	}

	
	
	@GetMapping("/all_job_list")
	public String all_job_list(Model m)
	{		
		m.addAttribute("allJobs",jobService.getAllJobs());
		return "all_job_list";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model m) {
		
		System.out.println("session in dashboad...."+session);
		
		if(session==null)
			return "redirect:/login";
		
		m.addAttribute("allJobs",jobService.getAllJobs());
		m.addAttribute("name",service.getNameById((int)session.getAttribute("userId")));
		return "dashboard";
	}
	
	
	@GetMapping("/logout")
	public String logout()
	{
		session.removeAttribute("userId");
		session=null;
		return "login";
	}
	
	@GetMapping("/job_post")
	public String postJob()
	{
		if(session==null)
			return "redirect:/login";
		
		return "job_post";
	}
	
	@GetMapping("/apply_job")
	public String applyJob()
	{
		System.out.println("session in applyJob...."+session);
		
		
		if(session==null)
			return "redirect:/login";
		
		return "apply_job";
	}
	
	
	@GetMapping("/posted_job_list")
	public String posted_job_list() {
		if(session==null)
			return "redirect:/login";
		
		return "posted_job_list";
	}
	
}
