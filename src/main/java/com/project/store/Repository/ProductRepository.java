package com.project.store.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.store.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByCategoryName(String name);
}
