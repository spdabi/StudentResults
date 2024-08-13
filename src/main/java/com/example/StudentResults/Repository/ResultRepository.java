package com.example.StudentResults.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentResults.Entity.Results;


public interface ResultRepository extends JpaRepository<Results,Integer>  {

}
