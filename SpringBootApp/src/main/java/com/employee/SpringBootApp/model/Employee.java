package com.employee.SpringBootApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Employee {
	@Id
	private Integer employeeId;
	private String employeeName;
	private String role;
	
	public Employee() {
		super();
	}
	public Employee(Integer employeeId, String employeeName, String role) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.role = role;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "EmployeeModel [employeeId=" + employeeId + ", employeeName=" + employeeName + ", role=" + role + "]";
	}
	
}
