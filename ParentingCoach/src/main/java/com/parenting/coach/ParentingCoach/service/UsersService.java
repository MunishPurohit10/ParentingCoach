package com.parenting.coach.ParentingCoach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parenting.coach.ParentingCoach.data.Users;
import com.parenting.coach.ParentingCoach.data.UsersRepository;


@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}
	
	public Users getUser(int userId) {
		 return usersRepository.findById(userId).orElse(null);
	}
	
	public Users addUsers(Users users) {
		return usersRepository.save(users);
	}
	
	public void deleteUsers(int userId) {
		usersRepository.deleteById(userId);
	}
	
	public void updateUsers(Users user) {
		
		usersRepository.save(user);
	}
}
