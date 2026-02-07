package com.project.store.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.Entity.User;
import com.project.store.Repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	UserRepository userRep;

	public User login(String fullName, String password) {
		return userRep.findByFullNameAndPassword(fullName, password).stream().findFirst().orElse(null);
	}
}
