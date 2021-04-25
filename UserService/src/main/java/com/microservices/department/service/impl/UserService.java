package com.microservices.department.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.model.Department;
import com.microservices.model.User;
import com.microservices.user.repository.IUserDAO;
import com.microservices.user.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserDAO userDAO;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User(1, 1, "sumit"));
		users.add(new User(2, 2, "dinesh"));
		return users;

		// return userDAO.findAll();
	}

	@Override
	public void saveUser(User user) {
		userDAO.save(user);
	}

	@Override
	public User getUserById(int id) {
		User user = new User(1,1,"sumit");
		Department dept = restTemplate.getForObject("http://DEPT-SERVICE/department/"+user.getDepartmentId(), Department.class);
		user.setDepartmentId(dept.getDepartmentId());
		return user;
	}

}
