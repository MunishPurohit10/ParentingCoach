package com.parenting.coach.ParentingCoach.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parenting.coach.ParentingCoach.constant.MessageConstants;
import com.parenting.coach.ParentingCoach.data.Login;
import com.parenting.coach.ParentingCoach.data.Users;
import com.parenting.coach.ParentingCoach.service.LoginService;
import com.parenting.coach.ParentingCoach.service.UsersService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Controller
public class PersonalDetailsController extends BaseController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private UsersService userService;
	
	@GetMapping("addPersonalDetails")
	public String loginUser(@NotBlank @RequestParam(value = "loginName") String loginName,
			@NotBlank @RequestParam(value = "password") String password,
			@NotBlank @RequestParam(value = "firstName") String firstName,
			@NotBlank @RequestParam(value = "lastName") String lastName,
			@NotBlank @Email @RequestParam(value = "email") String email,
			@NotBlank @RequestParam(value = "phoneNumber") String phoneNumber,
			@NotBlank @RequestParam(value = "address") String address,
			@NotBlank @RequestParam(value = "country") String country,
			@NotBlank @RequestParam(value = "city") String city,
			@NotBlank @RequestParam(value = "zipCode") String zipCode,
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
		user.setType("consultant");
		Users userAfterSaving = userService.addUsers(user);
		
		Login login = new Login();
		login.setLoginName(loginName);
		login.setPassword(password);
		login.setCreationDate(LocalDateTime.now());
		login.setUpdateDate(LocalDateTime.now());
		login.setUsers(userAfterSaving);
		loginService.addLogin(login);
		
		model.addAttribute(MessageConstants.SUCCESS_MESSAGES, MessageConstants.NEW_USER_ADDED_SUCCESSFULLY);
		
		return "forward:login";
	}
	
	@Override
	public String viewName() {
		return "profile/userdetails";
	}
}
