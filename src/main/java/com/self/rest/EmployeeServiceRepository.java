package com.self.rest;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeServiceRepository extends CrudRepository<Employee, Long> {

	List<Employee> findByEmpId(long empId);
}
