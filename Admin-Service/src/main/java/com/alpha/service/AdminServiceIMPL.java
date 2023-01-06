package com.alpha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.model.Employee;
import com.alpha.repo.AdminRepository;

@Service
public class AdminServiceIMPL implements AdminService{

	@Autowired
	private AdminRepository rep;
	
	@Override
	public void addEmployee(Employee emp) {
		rep.save(emp);
	}

	@Override
	public List<Employee> getEmployeeList() {
		List<Employee> elist = rep.findAll();
		return elist;
	}
}
