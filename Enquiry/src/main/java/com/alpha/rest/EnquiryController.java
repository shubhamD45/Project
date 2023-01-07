package com.alpha.rest;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.model.Enquiry;
import com.alpha.service.EnquiryService;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
	
	@Autowired
	private EnquiryService service;
	
	@GetMapping("/")
	public String check() 
	{
		return "Enquiry Module Working";
	}
	
	@PostMapping("/saveEnquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody Enquiry enquiry) {
		service.saveEnquiry(enquiry);
		return new ResponseEntity<String>("Enquiry Data Saved", HttpStatus.CREATED);
	}
	
	@GetMapping("/enquiries")
	public ResponseEntity<List<Enquiry>> getEnquiryList(){
		List<Enquiry> list = service.getEnquiryList();
		return new ResponseEntity<List<Enquiry>> (list,HttpStatus.OK);
	}
	
	@GetMapping("/cibilScore/{custId}")
	public ResponseEntity<Integer> getCibilScore(@PathVariable Integer custId) {
		
		Enquiry en = service.getSingleEnquiry(custId);
		
		int min = 600;  
		int max = 900;  
		Random r=new Random();
		int i = r.nextInt(max-min)+min;
		en.setCibil(i);
		
		if(en.getCibil()>700)
			en.setEnquiryStatus("eligible");
		else
			en.setEnquiryStatus("low cibil");
		
		service.saveEnquiry(en);
	
		return new ResponseEntity<Integer>(i,HttpStatus.OK);
	}
	
	@GetMapping("/statusChange/{custId}")
	public void ChangeStatus(@PathVariable Integer custId) {
		
		Enquiry en = service.getSingleEnquiry(custId);
		
		if(en.getEnquiryStatus()=="low cibil")
			en.setEnquiryStatus("rejected");
		service.saveEnquiry(en);
	}
	
	@GetMapping("/deleteEnquiry/{custId}")
	public void deleteEnquiry(@PathVariable Integer custId) {
		
		Enquiry en = service.getSingleEnquiry(custId);
		if(en.getEnquiryStatus()=="eligible") {
			en.setEnquiryStatus("register");
			service.saveEnquiry(en);
		}		
	}
}
