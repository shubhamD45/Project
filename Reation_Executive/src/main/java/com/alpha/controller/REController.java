package com.alpha.controller;


import java.io.IOException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alpha.model.Customer;
import com.alpha.model.CustomerDocuments;
import com.alpha.model.Enquiry;
import com.alpha.service.REService;

@RestController
@RequestMapping("REAPI/")
public class REController {
	
	@Autowired
	private REService service;

	@GetMapping("/")
	public ResponseEntity<String> check() {
		
		return new ResponseEntity<String>("RE Working",HttpStatus.OK);
	}
	
	
	@PostMapping("/saveEnquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody Enquiry enquiry) {
		service.saveEnquiry(enquiry);
		
		return new ResponseEntity<String>("Enquiry Data Saved", HttpStatus.CREATED);
	}
	
	@PostMapping("/saveCustomerData")
	public ResponseEntity<String> saveCustomerData(@RequestBody Customer customer) {
		service.saveCustomerData(customer);
		
		return new ResponseEntity<String>("Customer Data Saved",HttpStatus.CREATED);
	}
	
	@PostMapping("/uploadDocuments")
	public ResponseEntity<String> uploadDocuments(
								@RequestPart MultipartFile f1,
								@RequestPart MultipartFile f2,
								@RequestPart MultipartFile f3,
								@RequestPart MultipartFile f4,
								@RequestPart MultipartFile f5,
								@RequestPart MultipartFile f6,
								@RequestParam int customerId
								) 
	throws IOException{
		
		CustomerDocuments cd = new CustomerDocuments();
		cd.setAddressProof(f1.getBytes());
		cd.setAdharCard(f2.getBytes());
		cd.setBankStatement(f3.getBytes());
		cd.setPanCard(f4.getBytes());
		cd.setPhoto(f5.getBytes());
		cd.setSalarySlips(f6.getBytes());
		cd.setCustomerId(customerId);
		service.uploadDocuments(cd);
		return new ResponseEntity<String>("Documents Uploaded", HttpStatus.OK);
	}
	
	@GetMapping("/getEnquiry")
	public ResponseEntity<List<Enquiry>> getAllEnquiry() {
	List<Enquiry> list =  service.getAllEnquiry();
		return new ResponseEntity<List<Enquiry>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer() {
	 	List<Customer> list = service.getAllCustomer();
	 	
	 	return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	
	
	
	
}
