package com.employee.SpringBootApp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employee.SpringBootApp.model.Employee;
import com.employee.SpringBootApp.repository.EmployeeRepository;
import com.employee.SpringBootApp.service.EmployeeService;

@SpringBootTest
public class EmployeeServiceTest {
	@Autowired
	private EmployeeService service;
	@MockBean
	private EmployeeRepository repo;
	
	@Test
	public void addEmployeeTest() {
		Employee emp = new Employee(1,"emp1", "Lead");
		when(repo.save(emp)).thenReturn(emp);
		assertEquals(emp,service.addEmployee(emp));
	}
	@Test
	public void getEmployeesTest() {
		Employee e1 = new Employee(1,"emp1","Lead");
		Employee e2 = new Employee(2,"emp2","Dev");
		Employee e3 = new Employee(3,"emp3","test");
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		when(repo.findAll()).thenReturn(employees);
		assertEquals(employees,service.getEmployees());
	}
}
