package com.alpha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.model.Customer;
import com.alpha.model.CustomerDocuments;
import com.alpha.repository.RE_Customer_Repository;
import com.alpha.repository.RE_Documents_Repository;


@Service
public class REServiceIMPL implements REService{

	
	
	@Autowired
	private RE_Customer_Repository cusrepo;
	
	@Autowired
	private RE_Documents_Repository docrepo;
	

	
	@Override
	public void saveCustomerData(Customer customer) {
	
		cusrepo.save(customer);
	}
	
	@Override
	public void uploadDocuments(CustomerDocuments cd) {
	
						docrepo.save(cd);
	}
	
	

	
	@Override
	public List<Customer> getAllCustomer() {
		
		return cusrepo.findAll();
	}
	

}
