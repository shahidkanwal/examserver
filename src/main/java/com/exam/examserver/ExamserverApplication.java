package com.exam.examserver;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.examserver.dao.UserDao;
import com.exam.examserver.models.Role;
import com.exam.examserver.models.User;
import com.exam.examserver.models.UserRole;
import com.exam.examserver.service.UserService;

@SpringBootApplication
public class ExamserverApplication  implements CommandLineRunner{

	@Autowired
	public UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");
		
//		User user = new User();
//		user.setFirstName("shahid");
//		user.setLastName("kanwal");
//		user.setUsername("shahidkanwal");
//		user.setPassword("123");
//		user.setEmail("shahidkanwal234@gmail.com");
//		user.setPhone("1234567");
//		user.setProfile("default.png");
//		
//		Role role =new Role(44L,"ADMIN");
//		UserRole userRole = new UserRole();
//		userRole.setUser(user);
//		userRole.setRole(role);
//		
//		Set<UserRole> userRoles = new HashSet<>();
//		userRoles.add(userRole);
//		
//		User createUser = this.userService.createUser(user, userRoles);
//		System.out.println(createUser.getUsername());
		
		
		
	}

}
