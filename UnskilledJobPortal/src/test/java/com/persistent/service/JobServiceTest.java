package com.persistent.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.persistent.dao.IAllAppliedJobDAO;
import com.persistent.dao.ICategoryDAO;
import com.persistent.dao.IJobDAO;
import com.persistent.dao.IUsersDAO;
import com.persistent.entity.AllAppliedJob;
import com.persistent.entity.AllPostedJobDetails;
import com.persistent.entity.AppliedUserDetails;
import com.persistent.entity.Category;
import com.persistent.entity.JobDetails;
import com.persistent.entity.PostJobForm;
import com.persistent.entity.Users;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class JobServiceTest {
	
	
	@MockBean
	IJobDAO jobDao;
	
	@MockBean
	IAllAppliedJobDAO allAppliedJobDao;
	
	@MockBean
	IUsersDAO usersDao;

	@MockBean
	ICategoryDAO categoryDao;

	
	@InjectMocks
	JobService jobService;
	
	@InjectMocks
	CategoryService categoryService;
	
	@InjectMocks
	UsersService usersService;

	@InjectMocks
	AllAppliedJobService allAppliedJobService;
	
	
	
	@Test
	public void testPopulateJobEntity()
	{
		PostJobForm postJob=new PostJobForm();
		postJob.setCategoryId("1");
		postJob.setWorkState("Maharashtra");
		postJob.setWorkCity("Pune");
		postJob.setWorkPincode(589678);
		postJob.setJobType("Monthly");
		postJob.setWorkArea("Hinjewadi");
		postJob.setWorkDescription("Need Maid for household works");
		postJob.setEstimatedCost(500);
		postJob.setLastDate("2021-9-9");
		
		
		JobDetails jobDetails=new JobDetails();
		jobDetails.setCategoryId(1);
		//jobDetails.setJobId(0);
		jobDetails.setJobType("Monthly");
		jobDetails.setWorkArea("Hinjewadi");
		jobDetails.setWorkCity("Pune");
		jobDetails.setWorkDescription("Need Maid for household works");
		jobDetails.setWorkPincode("589678");
		jobDetails.setWorkState("Maharashtra");
		jobDetails.setActive(true);
		jobDetails.setEstimatedCost(500);
		jobDetails.setAadharNo("111111111111");
		
		Date utilLastDate=null;;
		try {
			utilLastDate = new SimpleDateFormat("yyyy-MM-dd").parse(postJob.getLastDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 java.sql.Date sqlLastDate = new java.sql.Date(utilLastDate.getTime());		 
		 
		 Date utilTodayDate=new Date();			 
		 java.sql.Date sqlTodayDate = new java.sql.Date(utilTodayDate.getTime());
		 jobDetails.setLastDate(sqlLastDate);
		 jobDetails.setDateOfPost(sqlTodayDate);

		
		 assertNotNull(jobService.populateJobEntity(postJob, "111111111111"));
		//assertEquals(jobService.populateJobEntity(postJob, "111111111111"), jobDetails);
		
	}
	
	
	@Test
	public void testAddJobDetails()
	{
		Date utilTodayDate=new Date();
		Date lastDate = null;
		try {
			lastDate = new SimpleDateFormat("yyyy-MM-dd").parse("2021-9-9");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date LastDate = new java.sql.Date(lastDate.getTime());
		 java.sql.Date sqlTodayDate = new java.sql.Date(utilTodayDate.getTime());	
		 

		
		
		JobDetails details=new JobDetails();
		details.setAadharNo("111111111111");
		details.setCategoryId(1);
		details.setDateOfPost(sqlTodayDate);
		details.setEstimatedCost(3000);
		details.setJobType("Three Days");
		details.setLastDate(LastDate);
		details.setWorkArea("Hinjevadi");
		details.setWorkCity("Pune");
		details.setWorkDescription("Need painter for new house");
		details.setWorkPincode("411001");
		details.setWorkState("Maharashtra");


	     
		when(jobDao.insertJobDetails(details.getAadharNo(),details.getCategoryId(),details.getDateOfPost(),details.getEstimatedCost(),details.getJobType(),details.getLastDate(),details.getWorkArea(),details.getWorkCity(),details.getWorkDescription(),details.getWorkPincode(),details.getWorkState())).thenReturn(1);
				
		//verify(jobDao, times(1)).save((details.getAadharNo(),details.getCategoryId(),details.getDateOfPost(),details.getEstimatedCost(),details.getJobType(),details.getLastDate(),details.getWorkArea(),details.getWorkCity(),details.getWorkDescription(),details.getWorkPincode(),details.getWorkState()););
		assertEquals(jobService.addJobDetails(details),1);
		
	}
	
	@Test
	public void testGetAllPostedJobs()
	{
		List<JobDetails> jobDetailsList=new ArrayList<>();
		jobDetailsList.add(new JobDetails(4, "123", 4, "Maharshtra", "Pune", "123", "Hinjevadi", "Maid", true, 500, null, null, "Normal", null));
		jobDetailsList.add(new JobDetails(3, "123", 3, "Maharshtra", "Pune", "13", "Hinjevadi", "Painter", true, 5000, null, null, "Normal", null));
		jobDetailsList.add(new JobDetails(2, "123", 2, "Maharshtra", "Pune", "12", "Hinjevadi", "Presscontroll", true, 1500, null, null, "Normal", null));
		jobDetailsList.add(new JobDetails(1, "123", 1, "Maharshtra", "Pune", "1234", "Hinjevadi", "Plumber", true, 1800, null, null, "Normal", null));
		when(jobDao.findAllById("123")).thenReturn(jobDetailsList);
		assertEquals(jobService.getAllPostedJobs("123"), jobDetailsList);
	}
	
	
	//@Test 
	public void testProcessAllPostedJobs()
	{
		List<JobDetails> jobDetailsList=new ArrayList<>();
		JobDetails details=new JobDetails();
		
		when(categoryDao.findById(1)).thenReturn(new Category(1,"Maid"));
		String categoryName=categoryService.getCategoryNameById(1);
		
		details.setJobId(1);
		details.setJobType("Weekly");
		details.setWorkArea("Hinjevadi");
		details.setWorkDescription("Maid");
		details.isActive();
		details.setDateOfPost(null);
		details.setLastDate(null);
		details.setCategoryId(1);
		details.setCategoryId(0);
		
		jobDetailsList.add(details);
		
		
		
		//categoryService.getCategoryNameById(job.getCategoryId())
		
		List<AllPostedJobDetails> allPostedJobDetails=new ArrayList<>();
		AllPostedJobDetails a=new AllPostedJobDetails();
		a.setJobId("1");
		a.setJobType("Weekly");
		a.setWorkArea("Hinjevadi");
		a.setWorkDescription("Maid");
		a.setStatus("Assigned");
		a.setDateOfPost(null);
		a.setLastDate(null);
		a.setCategoryName(categoryName);
		allPostedJobDetails.add(a);
		
		assertEquals(jobService.processAllPostedJobs(jobDetailsList), allPostedJobDetails);
		
	}
	
	//@Test
	public void testGetDetailsOfAllAppliers()
	{
		List<AllAppliedJob> apllied=new ArrayList<>();
		AllAppliedJob app=new AllAppliedJob();
		app.setAadharWorker("123");
		app.setjobId(1);
		AllAppliedJob app1=new AllAppliedJob();
		app1.setjobId(1);
		app1.setAadharWorker("1234");
		apllied.add(app);
		apllied.add(app1);
		
		
		Users user=new Users();
		user.setAadhar("123");
		user.setAddress("Hinjevadi");
		user.setContact("1234567890");
		user.setFirstName("Smith");
		user.setLastName("Alex");
		user.setGender("M");
		
		
		Users user1=new Users();
		user1.setAadhar("1234");
		user1.setAddress("Hinjevadi");
		user1.setContact("7896567890");
		user1.setFirstName("Smith");
		user1.setLastName("Alex");
		user1.setGender("M");
		

		
		List<String> usersAadharList=new ArrayList<>();
		usersAadharList.add("111111111111");
		usersAadharList.add("222222222222");

		when(allAppliedJobDao.findAllUserAadhar(1)).thenReturn(usersAadharList);
		
		assertEquals(allAppliedJobService.getAllWhoApplied(1),usersAadharList);
		
	
		
		
		
		List<AppliedUserDetails> appliedUserDetailsList=new ArrayList<>();
		AppliedUserDetails aud=new AppliedUserDetails();
		aud.setAadharNo("123");
		aud.setAddress("Hinjevadi");
		aud.setFullName("Smith Alex");
		aud.setJobId("1");
		aud.setMobileNo("1234567890");
		aud.setGender("Male");
		
		
		
		
		AppliedUserDetails aud1=new AppliedUserDetails();
		aud.setAadharNo("1234");
		aud.setAddress("Hinjevadi");
		aud.setGender("Male");
		aud.setFullName("Alex Smith");
		aud.setJobId("1");
		aud.setMobileNo("7896567890");
		
		
		appliedUserDetailsList.add(aud);
		appliedUserDetailsList.add(aud1);
		
		//assertEquals(service.getDetailsOfAllAppliers(1),appliedUserDetailsList);
	}
	
	@Test
	public void testAssignJobToAadharNo()
	{
		JobDetails detail=new JobDetails();
		detail.setAadharNo("123");
		detail.setJobId(1);
		detail.setCategoryId(1);
		detail.setWorkState("Maharashtra");
		detail.setWorkCity("Pune");
		detail.setWorkPincode("12345");
		detail.setWorkArea("Hinjevadi");
		detail.setWorkDescription("Maid");
		detail.isActive();
		detail.setEstimatedCost(500);
		detail.setDateOfPost(null);
		detail.setLastDate(null);
		detail.setJobType("Weekly");
		detail.setJobAssignedTo("123");
		
		
		when(jobDao.setJobAssignedToOfJobId("123", 1)).thenReturn(1);
		assertEquals(1, jobService.assignJobToAadharNo(1, "123"));
		
	}
	
	@Test
	public void testGetSelectedWorkerAadharNo()
	{
		when(jobDao.findSelectedWorkerAadharNo(1)).thenReturn("111111111111");
		assertEquals("111111111111", jobService.getSelectedWorkerAadharNo(1));
	}
	
	@Test
	public void testGetJobDetailsById()
	{
		JobDetails jobDetail=new JobDetails();
		jobDetail.setAadharNo("123");
		jobDetail.setJobId(1);
		jobDetail.setCategoryId(1);
		jobDetail.setWorkState("Maharashtra");
		jobDetail.setWorkCity("Pune");
		jobDetail.setWorkPincode("12345");
		jobDetail.setWorkArea("Hinjevadi");
		jobDetail.setWorkDescription("Maid");
		jobDetail.isActive();
		jobDetail.setEstimatedCost(500);
		jobDetail.setDateOfPost(null);
		jobDetail.setLastDate(null);
		jobDetail.setJobType("Weekly");
		jobDetail.setJobAssignedTo("123");
		
		when(jobDao.findByJobId(1)).thenReturn(jobDetail);
		
		assertEquals(jobDetail, jobService.getJobDetailsById(1));
	}
		
	//@Test NotCompleted
	public void testJobsAppliedByWorkerById()
	{
		
	}

	//@Test NotCompleted
	public void testGetStatusofJob()
	{
		JobDetails jobDetail=new JobDetails();
		jobDetail.setAadharNo("123");
		jobDetail.setJobId(1);
		jobDetail.setCategoryId(1);
		jobDetail.setWorkState("Maharashtra");
		jobDetail.setWorkCity("Pune");
		jobDetail.setWorkPincode("12345");
		jobDetail.setWorkArea("Hinjevadi");
		jobDetail.setWorkDescription("Maid");
		jobDetail.isActive();
		jobDetail.setEstimatedCost(500);
		jobDetail.setDateOfPost(null);
		jobDetail.setLastDate(null);
		jobDetail.setJobType("Weekly");
		jobDetail.setJobAssignedTo("123");
		
		when(jobDao.findByJobId(1)).thenReturn(jobDetail);
		
		assertEquals(jobDetail, jobDao.findByJobId(1));
		
		
		when(usersDao.findAadharByUserId(1)).thenReturn("111111111111");
	
	
		String aadharNo="111111111111";
		
		assertEquals(jobService.getStatusofJob(1, 1),"Accepted");
		
		
//				if(job.getJobAssignedTo()==null)
//				{
//					return "PENDING";
//				}
//				else if(job.getJobAssignedTo().equals(aadhar))
//				{
//					return "ACCEPTED";
//				}
//				else 
//					return "REJECTED";
	}
			
	//@Test
	public void testGetAllJobs() {
		List<JobDetails> jobDetailsList=new ArrayList<>();
		jobDetailsList.add(new JobDetails(4, "123", 4, "Maharshtra", "Pune", "123", "Hinjevadi", "Maid", true, 500, null, null, "Normal", null));
		jobDetailsList.add(new JobDetails(3, "123", 3, "Maharshtra", "Pune", "13", "Hinjevadi", "Painter", true, 5000, null, null, "Normal", null));
		jobDetailsList.add(new JobDetails(2, "123", 2, "Maharshtra", "Pune", "12", "Hinjevadi", "Presscontroll", true, 1500, null, null, "Normal", null));
		jobDetailsList.add(new JobDetails(1, "123", 1, "Maharshtra", "Pune", "1234", "Hinjevadi", "Plumber", true, 1800, null, null, "Normal", null));
		
		when(jobDao.getAllJobs()).thenReturn(jobDetailsList);
		
		assertEquals(jobDetailsList, jobService.getAllJobs());
	}
	
	//@Test
	public void testGetAadharByJobId() {
		JobDetails jobDetail=new JobDetails();
		jobDetail.setAadharNo("111111111111");
		
		when(jobDao.findByJobId(1)).thenReturn(jobDetail);
		
		assertEquals("111111111111",jobDetail.getAadharNo());	
	}
	
}
