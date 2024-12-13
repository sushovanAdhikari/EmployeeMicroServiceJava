package com.self.rest;

import com.self.rest.Employee;

public interface EmployeeService {

	// public Employee getEmployeeInfo(String empId);
	public Employee getEmployeeInfo(String empId);

	public Iterable<Employee> getEmployees();

	public Employee addEmployee(Employee emp);
}
