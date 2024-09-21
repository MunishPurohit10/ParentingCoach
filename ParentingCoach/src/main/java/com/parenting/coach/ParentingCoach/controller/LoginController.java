package com.parenting.coach.ParentingCoach.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parenting.coach.ParentingCoach.data.Login;
import com.parenting.coach.ParentingCoach.data.Users;
import com.parenting.coach.ParentingCoach.service.LoginService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@GetMapping("login")
	public String login() {
		return loginPage();
	}
	
	@GetMapping("/")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("loginUser")
	public String loginUser(@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password, Model model,
			HttpSession session) {
		List<Login> listLogins = loginService.getAllLogin();
		Optional<Login> loginOptional = listLogins.stream().filter(login -> login.getLoginName().equals(name))
				.findFirst();
		
		if (loginOptional.isPresent()) {
			if (loginOptional.get().getPassword().equals(password)) {
				System.out.println("Inside logged in succesffully");
				Users user = loginOptional.get().getUsers();
				session.setAttribute("loginId", loginOptional.get().getLoginId());
				session.setAttribute("userId", user.getUserId());
				session.setAttribute("firstName", user.getFirstName());
				session.setAttribute("lastName", user.getLastName());
				model.addAttribute("firstName", user.getFirstName());
				model.addAttribute("lastName", user.getLastName());
				return "redirect:home";
			} else {
				// TODO: Add error message
				return "login";
			}
		}
		return "login";
	}
	
	@GetMapping("logout")
	public String loginUser(Model model,
			HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	@GetMapping("addNewUser")
	public String addNewUser() {
		return "profile/userdetails";
	}
	
}
