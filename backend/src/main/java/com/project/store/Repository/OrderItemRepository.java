package com.project.store.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.store.Entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	List<OrderItem> findByItemsforOrderId(Long id);
}
