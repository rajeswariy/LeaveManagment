package com.example.demo.service;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.emp;
import com.example.demo.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {
	@PersistenceContext
    private EntityManager manager;
	
	@Autowired 
	EmpRepository empRepository;
	public emp findByempName(String name) {
		emp e=null;
		// TODO Auto-generated method stub
		if(exists(name)==true){
			 e=empRepository.findOne(name);
			
			
			
			}
		return e;
	
	}
	
	@Override
	public boolean exists(String name) {
		// TODO Auto-generated method stub
		System.out.println("checking for existence"+empRepository.exists(name)+" "+name);
		return empRepository.exists(name);
		
	}
	
	
	 @Transactional
	@Override
	
	public boolean saveorupdate(emp e) {
		
		boolean var=false;
		// TODO Auto-generated method stub
		System.out.println(e.getName());
		if(exists(e.getName())){
			System.out.println("name exist");
		
			 try
			    {
			        manager.createNamedQuery("updateEmp", emp.class)
			        .setParameter(1, e.getFromdate())
			        .setParameter(2, e.getTodate())
			        .setParameter(3, e.getName())
			        .executeUpdate();
			         var=true;
			        return true;
			    }
			    catch (Exception ex)
			    { ex.printStackTrace();
			    	var=false;
			        return false;
			    }
		}
		System.out.println("var is"+var);
		return var;
	}

	
	
}
