package com.persistent.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.persistent.entity.AllPostedJobDetails;
import com.persistent.entity.AppliedUserDetails;
import com.persistent.entity.JobDetails;
import com.persistent.entity.PostJobForm;
import com.persistent.service.CategoryService;
import com.persistent.service.JobService;
import com.persistent.service.UsersService;


@Controller
public class JobController {


	@Autowired
	private JobService jobService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UsersService usersService;
	
	
	
	
	@GetMapping("/job_post")
	public String showPostJob(Model m,HttpServletRequest request) {
		
		//This method will show the job_post.html page and will also add model atrribute to store the data of post job form
		System.out.println("In show post job");
		
		
		//After adding session uncomment this code
		
//		HttpSession session=request.getSession();
//		int userId=(int) session.getAttribute("userId"); //userId is logged in user's user_id(auto-generated-value of users table)
//		String userType=(String) session.getAttribute("userType"); // userType can be "user"/"admin"
//		
//		//userType stored in session are "user" and "admin"
//		if(userId!=null) 
//		{			
//			if(userType=="admin")
//			{
//				System.out.println("Accessed denied, Admin cannot access users page");
//				return "redirect:/access_denied_user"; //if admin try to access a users page 
//			}
//		}
//		else
//		{
//			System.out.println("User not logged in");
//			return "redirect:/login";
//		}
			
			
		//<------------- CategoryName for Refernece ------------------------>
		
//		List<String> categoriesList=new ArrayList<>();
//		categoriesList.add("Maid");
//		categoriesList.add("Cook");
//		categoriesList.add("Watchman");
//		categoriesList.add("Carpenter");
//		categoriesList.add("Driver");
//		categoriesList.add("Caretaker");
//		categoriesList.add("Nanny");
//		categoriesList.add("Electrician");
//		categoriesList.add("Plumber");
//		categoriesList.add("Sweeper");
//		categoriesList.add("Gardener");
//		categoriesList.add("Washerman");
//		categoriesList.add("Car Mechanic");
//		categoriesList.add("Bike Mechanic");
//		categoriesList.add("Painter");
//		categoriesList.add("Mason");
//		categoriesList.add("Sanitation Worker");
//		categoriesList.add("Home Tutor");
//		

				
		//categoryService.addCategory(new Category("Maid"));
//		categoryService.addCategory(new Category("Painter"));
//		categoryService.addCategory(new Category("Cook"));
//		categoryService.addCategory(new Category("Carpenter"));
//		categoryService.addCategory(new Category("Electrician"));
		
		//categoryService.addCategory(new Category("Washerman"));
		
		
		//<------------- -------------------------------- -------------------->
	
	
		//postJobForm is model attribute the data of user input will be stored in this
		m.addAttribute("postJobForm",new PostJobForm());
		
		//Fetching the categories from database using categoryService
		m.addAttribute("categoriesList",categoryService.getAllCategories());
		
		//Fetching the States from category service 
		m.addAttribute("statesList",categoryService.getAllStates());
		
		//Fetching the jobTypes from category service
		m.addAttribute("jobTypeList",categoryService.getAllJobType());
		
		return "job_post";
	}
	
	@PostMapping("/job_post")
	public String processPostJob(@Valid @ModelAttribute("postJobForm") PostJobForm postJobForm,BindingResult result,Model m,HttpServletRequest request) {
	
		System.out.println("In process Post job");
		
		//After the user click the submit buttom it will come here 
		//and if there is any error it will again redirect to job_post page
		
		
		
		//After adding session uncomment this code
		
//		HttpSession session=request.getSession();
//		int userId=(int) session.getAttribute("userId"); //userId is logged in user's user_id(auto-generated-value of users table)
//		String userType=(String) session.getAttribute("userType"); // userType can be "user"/"admin"
//		
//		//userType stored in session are "user" and "admin"
//		if(userId!=null) 
//		{			
//			if(userType=="admin")
//			{
//				System.out.println("Accessed denied, Admin cannot access users page");
//				return "redirect:/access_denied_user"; //if admin try to access a users page
//			}
//		}
//		else
//		{
//			System.out.println("User not logged in");
//			return "redirect:/login";
//		}
		
		
	
		System.out.println(postJobForm);
		
		// This will check the validation error in postJob form filled by user
		// If it has error it will redirect again to that page and prompt the user to change the values
		
		if(result.hasErrors()) 
		{
			m.addAttribute("categoriesList",categoryService.getAllCategories());
			m.addAttribute("statesList",categoryService.getAllStates());
			m.addAttribute("jobTypeList",categoryService.getAllJobType());
			
			return "job_post";
		}
		
		
		System.out.println("In process Post job");
		
		//String aadharNo =usersService.getUserAadharUsingUserId(userId); //uncomment this code after uncommenting session code
		
		String aadharNo =usersService.getUserAadharUsingUserId(1); ////comment this code after uncommenting session code
		
		System.out.println("AadharNo according to userId "+aadharNo);
		
		JobDetails jobDetails=jobService.populateJobEntity(postJobForm, aadharNo);   
		
		
		jobService.addJobDetails(jobDetails);
		
		System.out.println(postJobForm);

		 //after job is posted successfully it will redirect to all posted job where the user can also see his recently posted job
		return "redirect:/posted_job_list";
	}
	
	@GetMapping("/posted_job_list")
	public String show_posted_job_list(Model m,HttpServletRequest request) {
		System.out.println("in all posted job details controller");
		
		//This method will display the details of all job posted by the loggedn in user
		
		
		//After adding session uncomment this code
		
//		HttpSession session=request.getSession();
//		int userId=(int) session.getAttribute("userId"); //userId is logged in user's user_id(auto-generated-value of users table)
//		String userType=(String) session.getAttribute("userType"); // userType can be "user"/"admin"
//		
//		//userType stored in session are "user" and "admin"
//		if(userId!=null) 
//		{			
//			if(userType=="admin")
//			{
//				System.out.println("Accessed denied, Admin cannot access users page");
//				return "redirect:/access_denied_user"; //if admin try to access a users page
//			}
//		}
//		else
//		{
//			System.out.println("User not logged in");
//			return "redirect:/login";
//		}
		
		//String aadharNo =usersService.getUserAadharUsingUserId(userId); //uncomment this code after uncommenting session code
		
		String aadharNo =usersService.getUserAadharUsingUserId(1); ////comment this code after uncommenting session code
		
		System.out.println("AadharNo according to userId "+aadharNo);
		
		
		
		List<JobDetails> jobDetailsList =jobService.getAllPostedJobs(aadharNo);
		
		List<AllPostedJobDetails> allPostedJobs=jobService.processAllPostedJobs(jobDetailsList);
		
		System.out.println("allPostedJobs");
		
		//model attribute allPostedJobList contains details of all job posted by user
		m.addAttribute("allPostedJobList",allPostedJobs);
		
		return "posted_job_list";	
	}
	
	@GetMapping("/job_applied_list")
	public String job_applied_list(@RequestParam int jobId,Model m,HttpServletRequest request) {
		System.out.println("-------------------------- job applied list "+jobId+"-----------------------------------");
		
		
		//This method will show the details of all users who applied for the job
		
		
		//After adding session uncomment this code
		
//		HttpSession session=request.getSession();
//		int userId=(int) session.getAttribute("userId"); //userId is logged in user's user_id(auto-generated-value of users table)
//		String userType=(String) session.getAttribute("userType"); // userType can be "user"/"admin"
//		
//		//userType stored in session are "user" and "admin"
//		if(userId!=null) 
//		{			
//			if(userType=="admin")
//			{
//				System.out.println("Accessed denied, Admin cannot access users page");
//				return "redirect:/access_denied_user"; //if admin try to access a users page
//			}
//		}
//		else
//		{
//			System.out.println("User not logged in");
//			return "redirect:/login";
//		}
		
		
		List<AppliedUserDetails> userDetails=jobService.getDetailsOfAllAppliers(jobId);
		
		
		if(userDetails.isEmpty())
			m.addAttribute("isEmpty","true");
		else 
		{
			System.out.println("Job Id "+jobId+" Assigned to "+jobService.getSelectedWorkerAadharNo(jobId));
			String assignedTo=jobService.getSelectedWorkerAadharNo(jobId);
			
			if(assignedTo==null)
				m.addAttribute("isAssigned", "false");
			else {
				m.addAttribute("isAssigned","true");
			}
			
			m.addAttribute("assignedTo",assignedTo);
				
			
			m.addAttribute("userDetails",userDetails);
			m.addAttribute("isEmpty","false");
		}
		return "job_applied_list";
	}
	
	// request url for select_candidate ==> select_candidate?jobId=1&aadharNo=111122223333
	
	@GetMapping("/select_candidate")
	public String select_candidate(@RequestParam int jobId,@RequestParam String aadharNo,Model m,HttpServletRequest request) {
		System.out.println("-------------------------- select candidate "+jobId+" aadharNo "+aadharNo+"-----------------------------------");
		
		
		//This method will be invoked when the job poster click on select candidate form all appliers list
		
		
		//After adding session uncomment this code
		
//		HttpSession session=request.getSession();
//		int userId=(int) session.getAttribute("userId"); //userId is logged in user's user_id(auto-generated-value of users table)
//		String userType=(String) session.getAttribute("userType"); // userType can be "user"/"admin"
//		
//		//userType stored in session are "user" and "admin"
//		if(userId!=null) 
//		{			
//			if(userType=="admin")
//			{
//				System.out.println("Accessed denied, Admin cannot access users page");
//				return "redirect:/access_denied_user"; //if admin try to access a users page
//			}
//		}
//		else
//		{
//			System.out.println("User not logged in");
//			return "redirect:/login";
//		}
		
			
		int result=jobService.assignJobToAadharNo(jobId, aadharNo);
		
		
		return "redirect:/job_applied_list?jobId="+jobId ;
	}
}
