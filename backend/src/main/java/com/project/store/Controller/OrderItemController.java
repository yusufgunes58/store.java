package com.project.store.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.store.Entity.OrderItem;
import com.project.store.Service.OrderItemService;

@RestController
@RequestMapping("orderitems")
@CrossOrigin(origins = "*")
public class OrderItemController {

	@Autowired
	OrderItemService orderItemSer;
	
	@GetMapping
	public List<OrderItem> showAllOrderItems() {
		return orderItemSer.showAllOrderItems();
	}
	
	@GetMapping("{id}")
	public List<OrderItem> showOrderItem(@PathVariable Long id) {
		return  orderItemSer.showOrderItem(id);
	}
	
	@PostMapping("update/{orderId}/{productId}/{quantity}")
	public String updateOrderItem(@PathVariable Long orderId,@PathVariable Long productId,@PathVariable int quantity) {
		return orderItemSer.updateOrderItem(orderId, productId, quantity);
	}
	
	@DeleteMapping("delete/{orderId}/{productId}") 
		public String deleteProductfromOrderItem(@PathVariable Long orderId,@PathVariable Long productId) {
			return orderItemSer.deleteProductfromOrderItem(orderId, productId);
		}

}
