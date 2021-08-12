package com.persistent.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IJobDAO;
import com.persistent.entity.AllPostedJobDetails;
import com.persistent.entity.AppliedUserDetails;
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
		jobDetails.setActive(true);
		jobDetails.setDateOfPost(sqlTodayDate);
		jobDetails.setEstimatedCost(postJobForm.getEstimatedCost());
		//jobDetails.setJobAssignedTo(); will be populated by other functionality[Apply Job]

		System.out.println(jobDetails);
		return jobDetails;
	}
	
	
	public void addJobDetails(JobDetails job)
	{
		//dao.save(job);
		dao.insertJobDetails(job.getAadharNo(),job.getCategoryId(),job.getDateOfPost(),job.getEstimatedCost(),job.getJobType(),job.getLastDate(),job.getWorkArea(),job.getWorkCity(),job.getWorkDescription(),job.getWorkPincode(),job.getWorkPincode());
	}
	
	
	public List<JobDetails> getAllPostedJobs(String aadharNo)
	{
		List<JobDetails> jobDetailsList=dao.findAllById(aadharNo);
		System.out.println(jobDetailsList);
		return jobDetailsList;
		
	}
	
	public List<AllPostedJobDetails> processAllPostedJobs(List<JobDetails> jobDetailsList)
	{
		List<AllPostedJobDetails> allPostedJobDetails=new ArrayList<>();
		
		for(JobDetails job:jobDetailsList)
		{
			AllPostedJobDetails apjd=new AllPostedJobDetails();
			
			apjd.setJobId(String.valueOf(job.getJobId()));
			apjd.setJobType(job.getJobType());
			apjd.setWorkArea(job.getWorkArea());
			apjd.setWorkDescription(job.getWorkDescription());
			
			if(job.isActive())
				apjd.setStatus("Not Assigned");
			else
				apjd.setStatus("Assigned");
			
			
			apjd.setDateOfPost(String.valueOf(job.getDateOfPost()));
			apjd.setLastDate(String.valueOf(job.getLastDate()));
			
			apjd.setCategoryName(categoryService.getCategoryNameById(job.getCategoryId()));
			
			allPostedJobDetails.add(apjd);
			
			
		}
		System.out.println(allPostedJobDetails);
		return allPostedJobDetails;
	}
	
	

	public List<AppliedUserDetails> getDetailsOfAllAppliers(int jobID)
	{
		List<String> usersAadharNoList=allAppliedJobService.getAllWhoApplied(jobID);
		System.out.println("-------JobId "+jobID +" User AadharList "+usersAadharNoList);
		return allAppliedJobService.getDetailsOfAppliedUser(usersAadharNoList, String.valueOf(jobID));
		
	}
	
	public int  assignJobToAadharNo(int jobId,String aadharNo)
	{
		return dao.setJobAssignedToOfJobId(aadharNo, jobId);
	}
	
	public String getSelectedWorkerAadharNo(int jobId)
	{
		return dao.findSelectedWorkerAadharNo(jobId);
	}
	
}
