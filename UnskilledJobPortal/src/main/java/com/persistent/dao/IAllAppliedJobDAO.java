package com.persistent.dao;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entity.AllAppliedJob;

public interface IAllAppliedJobDAO extends CrudRepository<AllAppliedJob, Integer> {

}
