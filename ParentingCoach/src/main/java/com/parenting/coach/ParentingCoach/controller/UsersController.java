package com.parenting.coach.ParentingCoach.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parenting.coach.ParentingCoach.data.Users;
import com.parenting.coach.ParentingCoach.service.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;

	@GetMapping("users")
	public List<Users> getAllUsers() {
		return usersService.getAllUsers();
	}

	@GetMapping("users/{userId}")
	public Users getUsers(@PathVariable int userId) {
		return usersService.getUser(userId);
	}

	@RequestMapping(method = RequestMethod.POST, path = "users")
	public Users addUsers(@RequestBody Users user) {
		System.out.println("Users Test " + user);
		return usersService.addUsers(user);
	}

	@DeleteMapping("users/{userId}")
	public void deleteUsers(@PathVariable int userId) {
		usersService.deleteUsers(userId);
	}
}
