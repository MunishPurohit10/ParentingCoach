package com.parenting.coach.ParentingCoach.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parenting.coach.ParentingCoach.constant.MessageConstants;
import com.parenting.coach.ParentingCoach.data.Users;
import com.parenting.coach.ParentingCoach.data.WorkshopEvent;
import com.parenting.coach.ParentingCoach.service.UsersService;
import com.parenting.coach.ParentingCoach.service.WorkshopEventService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotBlank;

@Controller
public class WorkshopController extends BaseController {
	@Autowired
	private WorkshopEventService  workshopEventService;
	@Autowired
	private UsersService usersService;
	
	@GetMapping("confirmWorkshop")
	public String confirmWorkshopAdding(@NotBlank @RequestParam(value = "workshop_name") String workshopName,
			@NotBlank @RequestParam(value = "workshop_description") String workshopDescription,
			@NotBlank @RequestParam(value = "event_date") String eventDate,
			@NotBlank @RequestParam(value = "duration") String duration,
			@NotBlank @RequestParam(value = "capacity") String capacity,
			Model model, HttpSession session) {
		WorkshopEvent workshopEvent = new WorkshopEvent();
		workshopEvent.setCreationDate(LocalDateTime.now());
		System.out.println("eventDate " + eventDate);
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
		.appendPattern("yyyy-MM-dd'T'[[HH][:mm][:ss][.SSS]]")
        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
        .toFormatter(); 
		LocalDateTime eventLocalDate = LocalDateTime.parse(eventDate, formatter);
		workshopEvent.setEventDateTime(eventLocalDate);
		workshopEvent.setIsActive(true);
		workshopEvent.setUpdateDate(LocalDateTime.now());
		workshopEvent.setWorkshopDescription(workshopDescription);
		workshopEvent.setWorkshopName(workshopName);
		workshopEvent.setCapacity(Integer.parseInt(capacity));
		Long userId = (Long) session.getAttribute("userId");
		Users user = usersService.getUser(Integer.parseInt("" + userId));
		workshopEvent.setUser(user);
		workshopEvent.setDuration(Integer.parseInt(duration));
		
		workshopEventService.addWorkshopEvent(workshopEvent);
		
		model.addAttribute(MessageConstants.SUCCESS_MESSAGES, MessageConstants.WORKSHOP_ADDED_SUCCESSFULLY);

		return "forward:home";
	}
	
	@GetMapping("deleteWorkshop")
	public String deleteWorkshop(@RequestParam(value = "workshopEvents") String[] workshopEventIds, Model model) {
		for (String workshopEventId : workshopEventIds) {
			workshopEventService.deleteWorkshopEvent(Integer.parseInt(workshopEventId));
		}
		
		model.addAttribute(MessageConstants.SUCCESS_MESSAGES, MessageConstants.WORKSHOPS_DELETED_SUCCESSFULLY);

		return "redirect:home";
	}
	
	@Override
	public String viewName() {
		return "book/register_workshop";
	}
}