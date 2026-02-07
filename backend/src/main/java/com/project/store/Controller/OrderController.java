package com.project.store.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.store.Entity.Order;
import com.project.store.Service.OrderService;

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*")
public class OrderController {

	@Autowired
	OrderService orderSer;

	@GetMapping
	public List<Order> showAllOrders() {
		return orderSer.showAllOrders();
	}

	@GetMapping("{id}")
	public Optional<Order> showOrderById(@PathVariable Long id) {
		return orderSer.showOrderById(id);
	}

	@PostMapping("new")
	public String newOrder(@RequestBody Order order) {
		if (order.getOrderDate() == null) {
            order.setOrderDate(LocalDateTime.now());
        }
        return orderSer.newOrder(order);
    }
	
	@DeleteMapping("delete/{id}")
	public String deleteOrder(@PathVariable Long id) {
		return orderSer.deleteOrder(id);
	}
	
	@GetMapping("/customer/{customerId}")
	public List<Order> getOrdersByCustomer(@PathVariable Long customerId) {
	    return orderSer.getOrdersByCustomerId(customerId);
	}
}
