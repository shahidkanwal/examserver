package com.exam.examserver.service.impl;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exam.examserver.dao.RoleDao;
import com.exam.examserver.dao.UserDao;
import com.exam.examserver.models.User;
import com.exam.examserver.models.UserRole;
import com.exam.examserver.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User localUser = this.userDao.findByUsername(user.getUsername());
		
		if (localUser != null) {
			
			System.out.println("User already present!!");
			
			throw new Exception("User already present");
		} else {
			for(UserRole ur:userRoles) {
				this.roleDao.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			localUser = this.userDao.save(user);
		}
		
		return localUser;
	}

	@Override
	public User getUserByUsername(String username) {
		return this.userDao.findByUsername(username);
		
	}

}
