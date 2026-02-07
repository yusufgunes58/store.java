package com.project.store.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.Entity.Role;
import com.project.store.Entity.User;
import com.project.store.Repository.RoleRepository;
import com.project.store.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	RoleRepository roleRep;
	
	@Autowired
	UserRepository userRep;
	
	public User createUser(User user) {
		Role defaultRole = roleRep
				              .findByName("ROLE_USER")
				              .orElseThrow(() -> new RuntimeException("Default role not found."));
		
		user.getRoles().add(defaultRole);
		
		return userRep.save(user);
	}
}
