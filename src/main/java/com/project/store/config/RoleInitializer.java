package com.project.store.config;

import org.springframework.stereotype.Component;

import com.project.store.Entity.Role;
import com.project.store.Repository.RoleRepository;

import jakarta.annotation.PostConstruct;

@Component
public class RoleInitializer {

	 private final RoleRepository roleRepository;

	    public RoleInitializer(RoleRepository roleRepository) {
	        this.roleRepository = roleRepository;
	    }
	
	    @PostConstruct
	    public void initRoles() {
	        if (roleRepository.findByName("ROLE_USER").isEmpty()) {
	            roleRepository.save(new Role(null, "ROLE_USER"));
	            roleRepository.save(new Role(null, "ROLE_ADMIN"));
	            roleRepository.save(new Role(null, "ROLE_SELLER"));
	        }
	    }
	
	
	 
	
	
}
