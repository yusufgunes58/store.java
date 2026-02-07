package com.project.store.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.Entity.Customer;
import com.project.store.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRep;

	public List<Customer> showAllCustomers() {
		return customerRep.findAll();
	}

	public List<Customer> findByFullNameContainingIgnoreCase(String keyword) {
	    return customerRep.findByFullNameContainingIgnoreCase(keyword);
	}

	public String addCustomer(Customer customer) {
		customerRep.save(customer);
		return "Customer saved!";
	}

}
