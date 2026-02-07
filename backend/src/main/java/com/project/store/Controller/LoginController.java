package com.project.store.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.store.Entity.User;
import com.project.store.Service.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public User login(@RequestParam String fullName, @RequestParam String password) {
		return loginService.login(fullName, password);
	}
}
