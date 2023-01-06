package com.alpha.service;

import java.util.List;


import com.alpha.model.Customer;
import com.alpha.model.CustomerDocuments;
import com.alpha.model.Enquiry;

public interface REService {

	void saveEnquiry(Enquiry enquiry);

	void saveCustomerData(Customer customer);

	void uploadDocuments(CustomerDocuments cd);

	List<Enquiry> getAllEnquiry();

	List<Customer> getAllCustomer();

	
}
