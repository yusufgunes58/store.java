package com.project.store.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.store.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	 List<User> findByFullNameAndPassword(String fullName, String password);
}
