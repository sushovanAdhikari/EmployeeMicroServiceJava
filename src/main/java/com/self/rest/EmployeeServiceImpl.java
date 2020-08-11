package com.self.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeServiceRepository rep;

	public Employee getEmployeeInfo(String empId) {

		List<Employee> empList = rep.findByEmpId(Long.parseLong(empId));
		// Iterator<Employee> allEmp = (Iterator<Employee>) rep.findAll();

		return empList.get(0);
	}

	public Iterable<Employee> getEmployees() {
		Iterable<Employee> allEmp = null;
		try {
			allEmp = rep.findAll();			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return allEmp;
	}

	public Employee addEmployee(Employee emp) {
		Employee addedEmployee = null;
		try {
			addedEmployee = rep.save(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return addedEmployee;
	}
}