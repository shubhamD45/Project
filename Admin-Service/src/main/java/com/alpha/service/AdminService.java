package com.alpha.service;

import java.util.List;

import com.alpha.model.Employee;

public interface AdminService {

	void addEmployee(Employee emp);
	List<Employee> getEmployeeList();

}
