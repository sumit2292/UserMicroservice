package com.microservices.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.model.User;

@Repository
public interface IUserDAO extends JpaRepository<User,Long> {

}
