package com.avl.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.avl.Feign.FeignRE;
import com.avl.Feign.feignEnquiry;
import com.avl.Model.Customer;
import com.avl.Model.Enquiry;




@RestController
@RequestMapping("/OEClient")
public class OEController 
{
	@Autowired
	private FeignRE f;
	
	@Autowired
	private feignEnquiry fe;
	
	
//
//	@PostMapping("/FeignsaveEnquiry")
//	public ResponseEntity<String> saveEnquiry(@RequestBody Enquiry enquiry)
//	{
//	f.saveEnquiry(enquiry);
//		
//		return new ResponseEntity<String>("Enquiry Data Saved", HttpStatus.CREATED);
//	}
	
	
	@PostMapping("/feignsaveCustomerData")
	public ResponseEntity<String> saveCustomerData(@RequestBody Customer customer) 
	{
	f.saveCustomerData(customer);
		
		return new ResponseEntity<String>("Customer Data Saved",HttpStatus.CREATED);
	}

//	@GetMapping("/feigngetAllEnquiry")
//	public ResponseEntity<List<Enquiry>>getAllEnquiry()
//	{
//			List<Enquiry> l=f.getAllEnquiry();
//		
//		return new ResponseEntity<List<Enquiry>>(l,HttpStatus.OK);
//	}
	
	
	@GetMapping("/feigngetAllCustomer")
	public ResponseEntity<List<Customer>>getAllCustomer()
	{
		List<Customer> c= f.getAllCustomer();
		return new ResponseEntity<List<Customer>>(c,HttpStatus.OK);
	}
	
//	@GetMapping("/feigngetEnquiryByid/{id}")
//	public ResponseEntity<Enquiry>getEnquiryByid(@PathVariable int id)
//	{
//		Enquiry e= f.getEnquiryByid(id);
//		return new ResponseEntity<Enquiry>(e,HttpStatus.OK);
//	}
	
	
	@PostMapping("/FeignsaveEnquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody Enquiry enquiry) 
	{
		fe.saveEnquiry(enquiry);
		return new ResponseEntity<String>("Enquiry Data Saved", HttpStatus.CREATED);
	}
	
	

	@GetMapping("/Feignenquiries")
	public ResponseEntity<List<Enquiry>> getEnquiryList()
	{
		List<Enquiry> list = fe.getEnquiryList();
		return new ResponseEntity<List<Enquiry>> (list,HttpStatus.OK);
	}

	}