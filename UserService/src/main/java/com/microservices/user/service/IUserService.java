package com.microservices.user.service;

import java.util.List;

import com.microservices.model.User;

public interface IUserService {

	public User getUserById(int id);
	
	public List<User> getUsers();

	public void saveUser(User user);

}
