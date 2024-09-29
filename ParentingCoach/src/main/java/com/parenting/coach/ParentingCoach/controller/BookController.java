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
import com.parenting.coach.ParentingCoach.data.BookSession;
import com.parenting.coach.ParentingCoach.data.BookWorkshop;
import com.parenting.coach.ParentingCoach.data.Offer;
import com.parenting.coach.ParentingCoach.data.Users;
import com.parenting.coach.ParentingCoach.data.WorkshopEvent;
import com.parenting.coach.ParentingCoach.email.EmailService;
import com.parenting.coach.ParentingCoach.service.BookSessionService;
import com.parenting.coach.ParentingCoach.service.BookWorkshopService;
import com.parenting.coach.ParentingCoach.service.OfferService;
import com.parenting.coach.ParentingCoach.service.UsersService;
import com.parenting.coach.ParentingCoach.service.WorkshopEventService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotBlank;

@Controller
public class BookController extends BaseController {
	@Autowired
	private EmailService emailService;
	@Autowired
	private BookSessionService bookSessionService;
	@Autowired
	private OfferService offerService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private BookWorkshopService bookWorkshopService;
	@Autowired
	private WorkshopEventService workshopEventService;
	
	@GetMapping("bookSlot")
	public String bookServiceSlot(@NotBlank @RequestParam(value = "offerId") String offerId,
			@NotBlank @RequestParam(value = "sessionIntervalStart") String sessionIntervalStart, 
			Model model, HttpSession session) {
		Offer offer = offerService.getOffer(Integer.parseInt(offerId));
		
		BookSession bookSession = new BookSession();
		bookSession.setCreationDate(LocalDateTime.now());
		
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
				.appendPattern("yyyy-MM-dd [[HH][:mm][:ss][.SSSSSSSSS]]")
		        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
		        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
		        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
		        .toFormatter(); 
		LocalDateTime startTime = LocalDateTime.parse(sessionIntervalStart.replace("T", " "), formatter);
		bookSession.setStartTime(startTime);
		bookSession.setEndTime(startTime.plusMinutes(offer.getDuration()));
		bookSession.setOffer(offer);
		bookSession.setUpdateDate(LocalDateTime.now());
		// Get user from session
		Long userId = (Long) session.getAttribute("userId");
		Users user = usersService.getUser(Integer.parseInt("" + userId));
		bookSession.setUser(user);
		bookSessionService.addBookSession(bookSession);
		
		// TODO: Sent a mail to person booking
		// TODO: Send a mail to owner of the service
		model.addAttribute(MessageConstants.SUCCESS_MESSAGES, MessageConstants.PROGRAM_SLOT_BOOKED_SUCCESSFULLY);
		return "forward:home";
	}
	
	@GetMapping("bookWorkshopSlot")
	public String bookWorkshopSlot(@RequestParam(value = "workshopEventId") String workshopEventId,
			Model model, HttpSession session) {
		BookWorkshop bookWorkshop = new BookWorkshop();
		bookWorkshop.setCreationDate(LocalDateTime.now());
		bookWorkshop.setUpdateDate(LocalDateTime.now());
		// Get user from session
		Long userId = (Long) session.getAttribute("userId");
		Users user = usersService.getUser(Integer.parseInt("" + userId));
		bookWorkshop.setUser(user);
		WorkshopEvent workshopEvent = workshopEventService.getWorkshopEvent(Integer.parseInt(workshopEventId));
		bookWorkshop.setWorkshop(workshopEvent);

		bookWorkshopService.addBookWorkshop(bookWorkshop);
		// TODO: Sent a mail to person booking
		// TODO: Send a mail to owner of the service
		model.addAttribute(MessageConstants.SUCCESS_MESSAGES, MessageConstants.WORKSHOP_EVENT_REGISTERED_SUCCESSFULLY);

		return "forward:home";
	}
	
	@Override
	public String viewName() {
		return "book/book_service";
	}
}
