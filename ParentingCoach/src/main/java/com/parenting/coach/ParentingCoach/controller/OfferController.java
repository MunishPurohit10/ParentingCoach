package com.parenting.coach.ParentingCoach.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.parenting.coach.ParentingCoach.constant.MessageConstants;
import com.parenting.coach.ParentingCoach.data.Offer;
import com.parenting.coach.ParentingCoach.data.Users;
import com.parenting.coach.ParentingCoach.service.OfferService;
import com.parenting.coach.ParentingCoach.service.UsersService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotBlank;

@Controller
public class OfferController extends BaseController {
	@Autowired
	private OfferService offerService;
	@Autowired
	private UsersService usersService;

	@GetMapping("confirmOffering")
	public String confirmOfferAdding(@NotBlank @RequestParam(value = "offer_name") String offerName,
			@NotBlank @RequestParam(value = "offer_detail") String offerDetail,
			@NotBlank @RequestParam(value = "expiry_date") String expiryDate,
			@NotBlank @RequestParam(value = "duration") String duration,
			Model model, HttpSession session) {
		
		Offer offer = new Offer();
		offer.setOfferName(offerName);
		offer.setOfferDescription(offerDetail);
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
				.appendPattern("MM/dd/yyyy'T'[ [HH][:mm][:ss][.SSS]]")
		        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
		        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
		        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
		        .toFormatter(); 
		LocalDateTime expiryLocalDate = LocalDateTime.parse(expiryDate, formatter);
		offer.setExpiryDateTime(expiryLocalDate);
		offer.setCreationDate(LocalDateTime.now());
		offer.setUpdateDate(LocalDateTime.now());
		Long userId = (Long) session.getAttribute("userId");
		Users user = usersService.getUser(Integer.parseInt("" + userId));
		offer.setUser(user);
		offer.setIsActive(true);
		offer.setDuration(Integer.parseInt(duration));
		offerService.addOffer(offer);
		
		model.addAttribute(MessageConstants.SUCCESS_MESSAGES, MessageConstants.OFFER_ADDED_SUCCESSFULLY);
        return "forward:home";
	}

	@GetMapping("deleteOffering")
	public String deleteOffer(@RequestParam(value = "offers") String[] offerIds, Model model) {
		for (String offerId : offerIds) {
			offerService.deleteOffer(Integer.valueOf(offerId));
		}
		model.addAttribute(MessageConstants.SUCCESS_MESSAGES, MessageConstants.OFFERS_DELETED_SUCCESSFULLY);
		return "forward:home";
	}
	
	@Override
	public String viewName() {
		return "offering/add_offering";
	}
}
