package com.self.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/EmployeeRestService")
public class EmployeeServiceController {

	@Autowired
	EmployeeService service;

	@RequestMapping(value = "/getEmployeeInfo/{empId}", method = RequestMethod.GET, produces = { "application/json" })
	public Employee getEmployeeById(@PathVariable("empId") String empId) {

		System.out.println("@@ EmployeeServiceController.getEmployee" + empId);
		Employee emp = service.getEmployeeInfo(empId);

		// Iterator<Employee> empList = service.getEmployeeInfo(empId);

		return emp;
	}

	@RequestMapping(value = "/getEmployeeInfo", method = RequestMethod.GET, produces = { "application/json" })
	public Iterable<Employee> getEmployees() {

		System.out.println("@@ EmployeeServiceController.getEmployees");

		Iterable<Employee> empList = service.getEmployees();

		return empList;
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	@ResponseBody
	public Employee addEmployees(@RequestBody Employee emp) {

		Employee added = null;
		try {
			added = service.addEmployee(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("@@ EmployeeServiceController.getEmployees");

		return added;
	}
}
