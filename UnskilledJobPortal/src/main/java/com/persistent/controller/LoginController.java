package com.persistent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class LoginController {

	public static HttpSession session;
	
	@GetMapping("/login/{id}")
	public String login(HttpServletRequest request,@PathVariable String id)
	{
		session=request.getSession();
		session.setAttribute("user_aadhar", id);
		
		return "login succefull";
	}
	
}
