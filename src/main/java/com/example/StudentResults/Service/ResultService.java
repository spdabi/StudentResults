package com.example.StudentResults.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentResults.Dao.ResultDao;
import com.example.StudentResults.Entity.Results;

@Service
public class ResultService {
  @Autowired
  ResultDao rd;
	public String PostOverAll(List<Results> r) {
		return rd.POstOverAll(r);
	}

}
