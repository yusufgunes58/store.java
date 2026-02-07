package com.project.store.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.Entity.Customer;
import com.project.store.Entity.Order;
import com.project.store.Entity.User;
import com.project.store.Repository.CustomerRepository;
import com.project.store.Repository.OrderRepository;
import com.project.store.Repository.UserRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRep;

	@Autowired
	UserRepository userRep;
	
	@Autowired
	CustomerRepository customerRep;
	
	public List<Order> showAllOrders() {
		return orderRep.findAll();
	}

	public Optional<Order> showOrderById(Long id) {
		return orderRep.findById(id);
	}

	public String newOrder(Order order) {
		
		if (order.getOrderDate() == null) {
	        order.setOrderDate(LocalDateTime.now());
	    }
		
		Long userId = order.getUser().getId();
		User u = userRep.findById(userId).get(); 
		order.setUser(u);
		
		 Long custId = order.getCustomer().getId();
		 Customer c = customerRep.findById(custId).get();
		 order.setCustomer(c);
		
		 
		orderRep.save(order);
		
		return "Order saved!";
	}

	public String deleteOrder(Long id) {
		orderRep.deleteById(id);
		return "Order deleted!";
	}

	public List<Order> getOrdersByCustomerId(Long customerId) {
	    return orderRep.findByCustomerId(customerId);
	}
	
}
