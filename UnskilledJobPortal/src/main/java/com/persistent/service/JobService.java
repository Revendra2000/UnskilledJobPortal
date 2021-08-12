package com.persistent.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IJobDAO;
import com.persistent.entity.JobDetails;
import com.persistent.entity.PostJobForm;

@Service("jobService")
public class JobService {

	@Autowired
	private IJobDAO dao;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AllAppliedJobService allAppliedJobService;
	
	
	public JobDetails populateJobEntity(PostJobForm postJobForm,String aadharCard)
	{
		JobDetails jobDetails=new JobDetails();

		jobDetails.setCategoryId(Integer.parseInt(postJobForm.getCategoryId()));
		//jobDetails.setJobId(); auto generated value
		jobDetails.setJobType(postJobForm.getJobType());
		jobDetails.setWorkArea(postJobForm.getWorkArea());
		jobDetails.setWorkCity(postJobForm.getWorkCity());
		jobDetails.setWorkDescription(postJobForm.getWorkDescription());
		
		//converting the integer pincode to string pincode
		String pincode=String.valueOf(postJobForm.getWorkPincode());
		
		jobDetails.setWorkPincode(pincode);
		jobDetails.setWorkState(postJobForm.getWorkState());
		
		//Converting String to java.util Date
		Date utilLastDate=null;;
		try {
			utilLastDate = new SimpleDateFormat("yyyy-MM-dd").parse(postJobForm.getLastDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Util DAte"+utilLastDate);
		Date utilTodayDate=new Date();
		
		
		//Converting java.util Date to java.Sql date
		 java.sql.Date sqlLastDate = new java.sql.Date(utilLastDate.getTime());
		 java.sql.Date sqlTodayDate = new java.sql.Date(utilTodayDate.getTime());
		 System.out.println("Sql Date"+sqlLastDate);
		 System.out.println("Sql TodayDate"+sqlTodayDate);
		 
		jobDetails.setLastDate(sqlLastDate);
		jobDetails.setAadharNo(aadharCard);
		//jobDetails.setActive(true);
		jobDetails.setDateOfPost(sqlTodayDate);
		jobDetails.setEstimatedCost(postJobForm.getEstimatedCost());
		//jobDetails.setJobAssignedTo(); will be populated by other functionality[Apply Job]

		System.out.println(jobDetails);
		return jobDetails;
	}
	
	
	public void addJobDetails(JobDetails job) {
		dao.save(job);
}
	
}
