package com.employee.SpringBootApp.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.SpringBootApp.model.Employee;
import com.employee.SpringBootApp.repository.EmployeeRepository;

@Service
public class EmployeeService {
   @Autowired
   private EmployeeRepository repository;
   
   
   public Employee addEmployee(Employee employee) {  
	   return repository.save(employee);
   }
   
   public ArrayList<Employee> getEmployees(){
	   return (ArrayList<Employee>) repository.findAll();
   }
}
