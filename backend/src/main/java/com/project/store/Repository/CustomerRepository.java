package com.project.store.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.store.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByFullNameContainingIgnoreCase(String fullName);
	
}
