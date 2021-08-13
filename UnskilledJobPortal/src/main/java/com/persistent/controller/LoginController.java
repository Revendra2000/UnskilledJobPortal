package com.persistent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.persistent.service.JobService;
import com.persistent.service.UsersService;

@Controller
public class LoginController {

	public static HttpSession session;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private JobService jobService;
	
	
//main Home-page , accessible even if not logged in	
	@RequestMapping(value={"/all_job_list","/"},method=RequestMethod.GET)
	public String all_job_list(Model m)
	{		
		m.addAttribute("allJobs",jobService.getAllJobs());
		return "all_job_list";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signup() {
		return "signup";
	}
	
	
	@GetMapping("/login/{aadhar}")
	public String login(HttpServletRequest request,@PathVariable String aadhar,Model m)
	{		
		
		session=request.getSession();
		
			//---------------------adding userId and userType in session-------------------------------//
		
		session.setAttribute("userId", userService.getUserByAadharNo(aadhar).getUserId());
		if(userService.getUserByAadharNo(aadhar).getRoles()=="Role_User")
			session.setAttribute("userType","normal");
		else
			session.setAttribute("userType", "admin");
		
		m.addAttribute("allJobs",jobService.getAllJobs());
		return "redirect:/dashboard";
	}


	
	@GetMapping("/dashboard")
	public String dashboard(Model m) {
		
		System.out.println("session in dashboad...."+session);
		
		if(session==null)
			return "redirect:/login";
		
		m.addAttribute("allJobs",jobService.getAllJobs());
		m.addAttribute("name",userService.getNameById((int)session.getAttribute("userId")));
		return "dashboard";
	}
	
	
	@GetMapping("/logout")
	public String logout()
	{
		session.removeAttribute("userId");
		session=null;
		return "login";
	}

	
//	@GetMapping("/apply_job")
//	public String applyJob()
//	{
//		System.out.println("session in applyJob...."+session);
//		
//		
//		if(session==null)
//			return "redirect:/login";
//		
//		return "apply_job";
//	}
	
	
//	@GetMapping("/posted_job_list")
//	public String posted_job_list() {
//		if(session==null)
//			return "redirect:/login";
//		
//		return "posted_job_list";
//	}
	
}
