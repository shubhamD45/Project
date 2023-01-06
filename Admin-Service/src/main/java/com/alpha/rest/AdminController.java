package com.alpha.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alpha.model.Converter;
import com.alpha.model.Employee;
import com.alpha.model.EmployeeDto;
import com.alpha.service.AdminService;


@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@GetMapping("/")
	public ResponseEntity<String> checkAPI(){
		return new ResponseEntity<String>("Admin-Service Working", HttpStatus.OK);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<String> addEmployees(@RequestParam String firstName,
												@RequestParam String lastName,
												@RequestParam String role,
												@RequestParam String email,
												@RequestParam String gender,
												@RequestParam String birthDate,
												@RequestParam char[] password,
												@RequestParam MultipartFile f1) throws IOException{
	
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setRole(role);
		emp.setEmail(email);
		emp.setGender(gender);
		emp.setBirthDate(birthDate);
		emp.setPassword(password);
		emp.setProfile(f1.getBytes());
		service.addEmployee(emp);
		return new ResponseEntity<>("Employee added successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getEmployeeList(){
		
		List<Employee> eList = service.getEmployeeList();
		Converter con = new Converter();
		List<EmployeeDto> list = con.entityToDto(eList);
		return new ResponseEntity<List<EmployeeDto>>(list,HttpStatus.OK);
	}
	
	
	
	
	
}
