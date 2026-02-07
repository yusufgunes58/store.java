package com.project.store.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.Entity.Order;
import com.project.store.Entity.OrderItem;
import com.project.store.Entity.Product;
import com.project.store.Repository.OrderItemRepository;
import com.project.store.Repository.OrderRepository;
import com.project.store.Repository.ProductRepository;

@Service
public class OrderItemService {

	@Autowired
	OrderItemRepository orderItemRep;

	@Autowired
	ProductRepository productRep;

	@Autowired
	OrderRepository orderRep;

	public List<OrderItem> showAllOrderItems() {
		return orderItemRep.findAll();
	}

	public List<OrderItem> showOrderItem(Long id) {
		return orderItemRep.findByItemsforOrderId(id);
	}

	public String updateOrderItem(Long orderId, Long productId, int quantity) {
		Product p = productRep.findById(productId).get();
		Order order = orderRep.findById(orderId).get();

		if (p.getStock() < quantity) {
			return "Not enough stock!";
		}

		OrderItem existingItem = order.getOrderItems().stream().filter(i -> i.getProduct().getId().equals(productId))
				.findFirst().orElse(null);

		if (existingItem != null) {
			p.setStock(p.getStock() + existingItem.getQuantity());
			p.setStock(p.getStock() - quantity);
			existingItem.setQuantity(quantity);
			existingItem.setPrice(p.getPrice() * quantity);

			productRep.save(p);
			orderItemRep.save(existingItem);
			return "Order item updated!";
		}

		OrderItem newItem = new OrderItem();
		newItem.setProduct(p);
		newItem.setQuantity(quantity);
		newItem.setPrice(p.getPrice() * quantity);
		newItem.setOrder(order);

		p.setStock(p.getStock() - quantity);

		productRep.save(p);
		orderItemRep.save(newItem);

		return "Order item added!";

	}

	public String deleteProductfromOrderItem(Long orderId, Long productId) {

		Order order = orderRep.findById(orderId).get();

		OrderItem item = order.getOrderItems().stream().filter(o -> o.getProduct().getId().equals(productId))
				.findFirst().get();

		Product product = item.getProduct();
		product.setStock(product.getStock() + item.getQuantity());
		productRep.save(product);

		order.getOrderItems().remove(item);
		orderItemRep.delete(item);
		orderRep.save(order);

		return "Deleted product from order items!";

	}

}
