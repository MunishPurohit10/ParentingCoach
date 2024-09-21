package com.parenting.coach.ParentingCoach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parenting.coach.ParentingCoach.data.Login;
import com.parenting.coach.ParentingCoach.data.LoginRepository;


@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	
	public List<Login> getAllLogin() {
		return loginRepository.findAll();
	}
	
	public Login getLogin(int loginId) {
		 return loginRepository.findById(loginId).orElse(null);
	}
	
	public Login addLogin(Login login) {
		return loginRepository.save(login);
	}
	
	public void deleteLogin(int loginId) {
		loginRepository.deleteById(loginId);
	}
	
	public void updateLogin(Login login) {
		
		loginRepository.save(login);
	}
}
