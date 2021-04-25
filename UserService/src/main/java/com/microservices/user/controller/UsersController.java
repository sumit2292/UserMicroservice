package com.microservices.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.User;
import com.microservices.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	IUserService userService;

	@GetMapping("/list")
	public List<User> getAll() {
		return userService.getUsers();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Integer id) {
		return userService.getUserById(id);
	}

	@PostMapping("/save")
	public void saveUser(@RequestBody User user) {
		userService.saveUser(user);
	}

}
