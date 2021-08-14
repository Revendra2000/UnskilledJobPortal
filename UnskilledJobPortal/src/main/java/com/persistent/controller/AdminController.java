package com.persistent.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.persistent.dao.ICatDao;
import com.persistent.entity.Categories;
import com.persistent.entity.Users;
import com.persistent.service.AdminService;

//import com.mycompany.entity.Employee;
//import com.mycompany.service.EmployeeService;

@Controller
public class AdminController {
	
	
	@Autowired
	private AdminService service;
	

	@GetMapping("/admin/cat")
    public String getAllCategories(Model  model)
    {	
		List<Categories> catList=service.getCategories();
		
		model.addAttribute("catList", catList);
		System.out.println(model.getAttribute("catList"));
		return "admin_viewallcategory";
    }
	
	@RequestMapping("/admin/cat/add")
	public String addCategory(@ModelAttribute(value="cat") Categories catNew,Model model) {
		service.addCategory(catNew);   
		//empDao.insertEmp(empNew);    
	      // List<Categories> cat = empDao.getEmp();
	       //model.put("emp", emp);
	 
	       return "add_category";
		
		
	}
	
	@RequestMapping("/admin/cat/delete")
	public String deleteCat(@ModelAttribute(value="cat2") Categories catNew, Model model ) {
		service.deleteCategory(catNew.getCategory_id());   
	    List<Categories> catList = service.getCategories();
	    model.addAttribute("catList", catList);
	    System.out.println(model.getAttribute("catList"));
	 
	    return "admin_viewallcategory";  
	}
//	 @GetMapping("/cat/{category_id}")
//	//@GetMapping("/employees/{id}")
//	public Categories getEmployeeDetails(@PathVariable int category_id) {
//		return service.getCategory(category_id);
//	}
	

	@GetMapping("/admin/users")
    public String getAllUsers(Model model)
    {
		List<Users> usersList=service.getUsers();
		
		model.addAttribute("usersList", usersList);
		System.out.println(model.getAttribute("usersList"));
		return "admin_viewalluser";
       
    }
	@RequestMapping("/admin/users/delete")
	public String deleteUsers(@ModelAttribute(value="user") Users userNew, Model model ) {
		service.deleteUser(userNew.getAadhar_no());
		
		List<Users> usersList=service.getUsers();
		
		model.addAttribute("usersList", usersList);
		System.out.println(model.getAttribute("usersList"));
	 
		return "admin_viewalluser"; 
	}

}
