package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpDTO;
import com.example.demo.model.emp;
import com.example.demo.service.EmpService;



@CrossOrigin

@RestController
public class RestWebController {
	
	//HttpSession session=null;
	String name="";
@Autowired
EmpService empService;
public void setService(EmpService empService) {
    this.empService = empService;
}
	
	@RequestMapping(value = "/getemp", method = RequestMethod.POST, produces="application/json")
	public Map<String,Object> getempstatus(@RequestBody EmpDTO emp){
		System.out.println("Inside Controller");
		
		Map<String,Object> respMap=new HashMap<String, Object>();
		emp e=empService.findByempName(emp.getName());
		if(emp.getPwd().equals(e.getPwd())){
			System.out.println("success");
			   
	        //session.setAttribute("name",name);  
			name=emp.getName();
			System.out.println(name);
			respMap.put("resp", "success");}
		else{
			System.out.println("fail");
		respMap.put("resp", "fail");}
		
		return respMap;
	}
	

	//@RequestMapping(value = "/getusername", method = RequestMethod.POST, produces="application/json")
	/*public String getUserName()
	{  System.out.println("getting username");
		return name;
	}*/
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces="application/json")
	public boolean saveorupdate(@RequestBody EmpDTO emps){
		System.out.println("Inside save Controller");
		emp em=new emp();
		/*em.setName(name);*/
		em.setName(emps.getName());
		em.setFromdate(emps.getFromdate());
		em.setTodate(emps.getTodate());
		boolean var=empService.saveorupdate(em);
		return var;
		
	}
	
	
	
}