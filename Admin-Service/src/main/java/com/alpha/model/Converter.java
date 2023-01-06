package com.alpha.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data

public class Converter {
	
	public EmployeeDto entityToDto(Employee emp) {
		
		EmployeeDto empdto = new EmployeeDto();
		empdto.setFirstName(emp.getFirstName());
		empdto.setLastName(emp.getLastName());
		empdto.setEmail(emp.getEmail());
		empdto.setProfile(emp.getProfile());
		empdto.setRole(emp.getRole());
		return empdto;
	}
	
	public List<EmployeeDto> entityToDto(List<Employee> elist){
		
		return elist.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

}
