package com.exam.examserver.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.models.Role;
import com.exam.examserver.models.User;
import com.exam.examserver.models.UserRole;
import com.exam.examserver.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		user.setProfile("default.png");
		
		//create Role
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		//Add relation
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		//Create the set with roles
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(userRole);
		
		User createUser = this.userService.createUser(user, userRoles);
		return createUser;
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username ) {
		System.out.println("hi");
		
		return this.userService.getUserByUsername(username);
	}
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal ) {
		System.out.println("hi getCurrentUser");
		
		return this.userService.getUserByUsername(principal.getName());
	}

}
