package com.persistent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.persistent.dao.IUserDao;
import com.persistent.entity.Users;

@Controller
public class LoginController {

	@Autowired
	private IUserDao userdao;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(HttpServletRequest request) {
		
//		Users user = userdao.findById(aadhar_no);
//		
//		HttpSession session=request.getSession();
//		session.setAttribute("userid", userid);
		// session.setAttribute("usertype", usertype;
		return "login";
	}
	
	@RequestMapping(value="/admin/login",method=RequestMethod.GET)
	public String adminLogin(HttpServletRequest request) {
		
//		Users user = userdao.findById(aadhar_no);
//		
//		HttpSession session=request.getSession();
//		session.setAttribute("userid", userid);
		// session.setAttribute("usertype", usertype;
		return "admin_login";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "<h1>ADMIN</h1>";
	}
	
	@RequestMapping("/addUser")
	public String addUser(Users user) {
		userdao.save(user);
		 return "redirect:/login";
//		return "login";
	}
}
