package com.avl.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.avl.Model.Enquiry;

@FeignClient(name="enquiry-service")
public interface feignEnquiry 
{

	@PostMapping("/enquiry/saveEnquiry")
	public String saveEnquiry(Enquiry enquiry);

	@GetMapping("/enquiry/enquiries")
	public List<Enquiry> getEnquiryList();
	

}
