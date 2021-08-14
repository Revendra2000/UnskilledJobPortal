package com.persistent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminDashboardController {
	
	@RequestMapping(value="/categories",method=RequestMethod.GET)
	public String viewCategories() {
		return "admin_viewallcategory";
	}

}
