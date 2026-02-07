package com.project.store.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.store.Entity.Customer;
import com.project.store.Service.CustomerService;

@RestController
@RequestMapping("customer")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	CustomerService customerSer;

	@GetMapping
	public List<Customer> showAllCustomers() {
		return customerSer.showAllCustomers();
	}

	@GetMapping("/search")
	public List<Customer> findByFullNameContainingIgnoreCase(@RequestParam String fullName) {
	    return customerSer.findByFullNameContainingIgnoreCase(fullName);
	}

	@PostMapping("new")
	public String addCustomer(@RequestBody Customer customer) {
		return customerSer.addCustomer(customer);
	}

}
