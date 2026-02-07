package com.project.store.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.store.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByCustomerId(Long customerId);
	
}
