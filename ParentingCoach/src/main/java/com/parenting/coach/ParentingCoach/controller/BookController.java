package com.parenting.coach.ParentingCoach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.parenting.coach.ParentingCoach.email.EmailService;

@Controller
public class BookController {
	@Autowired
	private EmailService emailService;
	
	@GetMapping("bookSlot")
	public String bookServiceSlot(Model model) {
		// Sent a mail to person booking
		// Send a mail to owner of the service
		
		return "redirect:home";
	}
	
	@GetMapping("bookWorkshopSlot")
	public String bookWorkshopSlot(Model model) {
		// Sent a mail to person booking
		// Send a mail to owner of the service
		
		return "redirect:home";
	}
}
