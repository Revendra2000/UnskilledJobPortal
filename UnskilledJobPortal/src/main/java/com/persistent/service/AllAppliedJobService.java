package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IAllAppliedJobDAO;

@Service("allApplliedJobService")
public class AllAppliedJobService {

	@Autowired
	private IAllAppliedJobDAO dao;
	
}
