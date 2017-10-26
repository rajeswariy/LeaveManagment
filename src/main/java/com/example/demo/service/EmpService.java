package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.emp;

public interface EmpService {
	public emp findByempName(String name);
	boolean exists(String name);
	public boolean saveorupdate(emp e);
	
}
