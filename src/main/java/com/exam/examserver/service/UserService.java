package com.exam.examserver.service;

import java.util.Set;
import com.exam.examserver.models.User;
import com.exam.examserver.models.UserRole;

public interface UserService {
	
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	public User getUserByUsername(String username);
}
