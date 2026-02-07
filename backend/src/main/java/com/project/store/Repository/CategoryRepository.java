package com.project.store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.store.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	
}
