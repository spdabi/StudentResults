package com.example.StudentResults.Controller;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.StudentDetails.Entity.Student;
import com.example.StudentMarkSheet.Entity.MarkSheet;
import com.example.StudentResults.Entity.Results;
import com.example.StudentResults.Service.ResultService;

@RestController
public class ResultController {
	@Autowired
	RestTemplate rt;
	@Autowired
	ResultService rs;
	
	@PostMapping(value = "/getProductwithGst")
	public String PostOverAll(@RequestBody List<Results> r) {
		String url1 = "http://localhost:8080/Student/getByRool/";
		String url2 = "http://localhost:8083/PostsemMark/getSem1Tot/";
		String url3 = "http://localhost:8083/PostsemMark/gebytsem2/";
		
		r.forEach(x -> {
			int a = x.getroll_number();
			ResponseEntity<String> res1 = rt.exchange(url1 + a, HttpMethod.GET, null, String.class);
			String name = res1.getBody();
			x.setName(name);
			
			ResponseEntity<Integer> res2 = rt.exchange(url2 + a, HttpMethod.GET, null, Integer.class);
			int s1 = res2.getBody();
			ResponseEntity<Integer> res3 = rt.exchange(url3 + a, HttpMethod.GET, null, Integer.class);
			int s2 = res3.getBody();
			x.setPercentage((s1 + s2) / 2);
			int extramark = 5;
			if (x.getPercentage() >= 90) {
				x.setTotalmarks(s1 + s2 + extramark);
			} else {
				x.setTotalmarks(s1 + s2);
			}

			// x.setTotalmarks(s1+s2);

		});
		return rs.PostOverAll(r);
	}

}
