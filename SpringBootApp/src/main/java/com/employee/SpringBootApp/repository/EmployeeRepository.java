package com.employee.SpringBootApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.SpringBootApp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
