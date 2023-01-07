package com.alpha.service;

import java.util.List; 


import com.alpha.model.Customer;
import com.alpha.model.CustomerDocuments;


public interface REService {

	

	void saveCustomerData(Customer customer);

	void uploadDocuments(CustomerDocuments cd);

	

	List<Customer> getAllCustomer();



	
}
