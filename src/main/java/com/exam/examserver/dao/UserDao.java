package com.exam.examserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examserver.models.User;

public interface UserDao extends JpaRepository<User, Long>{

	public User findByUsername(String username);

}
