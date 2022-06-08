package com.employee.SpringBootApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.SpringBootApp.model.Employee;
import com.employee.SpringBootApp.service.EmployeeService;

@RestController
public class AppController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping(path="/addEmployee", consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
	public Employee add(@RequestBody Employee emp) {
		System.out.println("Employee Added succesfully -> "+emp);
		return service.addEmployee(emp);
	}	
	@GetMapping(path="/getEmployeesList", produces = MediaType.APPLICATION_XML_VALUE)
	public ArrayList<Employee> getAll(){
		return service.getEmployees();
	}
	
}
