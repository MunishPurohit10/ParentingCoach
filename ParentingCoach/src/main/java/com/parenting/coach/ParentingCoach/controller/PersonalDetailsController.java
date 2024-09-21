package com.parenting.coach.ParentingCoach.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parenting.coach.ParentingCoach.data.Login;
import com.parenting.coach.ParentingCoach.data.Users;
import com.parenting.coach.ParentingCoach.service.LoginService;
import com.parenting.coach.ParentingCoach.service.UsersService;
import jakarta.servlet.http.HttpSession;

@Controller
public class PersonalDetailsController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private UsersService userService;
	
	@GetMapping("addPersonalDetails")
	public String loginUser(@RequestParam(value = "loginName") String loginName,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "phoneNumber") String phoneNumber,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "country") String country,
			@RequestParam(value = "city") String city,
			@RequestParam(value = "zipCode") String zipCode,
			Model model,
			HttpSession session) {
		Users user = new Users();
		user.setAddress(address);
		user.setCity(city);
		user.setCountry(country);
		user.setCreationDate(LocalDateTime.now());
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setIsActive(true);
		user.setLastName(lastName);
		user.setPhoneNumber(phoneNumber);
		user.setUpdateDate(LocalDateTime.now());
		Users userAfterSaving = userService.addUsers(user);
		
		Login login = new Login();
		login.setLoginName(loginName);
		login.setPassword(password);
		login.setCreationDate(LocalDateTime.now());
		login.setUpdateDate(LocalDateTime.now());
		login.setUsers(userAfterSaving);
		loginService.addLogin(login);
		
		return "redirect:login";
	}
}
