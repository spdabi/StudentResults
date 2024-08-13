package com.example.StudentResults.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.StudentResults.Entity.Results;
import com.example.StudentResults.Repository.ResultRepository;

@Repository
public class ResultDao {
  @Autowired
  ResultRepository rp;
	public String POstOverAll(List<Results> r) {
	    rp.saveAll(r);
		return "Saved Successfully";
	}

}
