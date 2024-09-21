package com.parenting.coach.ParentingCoach.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parenting.coach.ParentingCoach.data.Article;
import com.parenting.coach.ParentingCoach.data.BookSession;
import com.parenting.coach.ParentingCoach.data.Offer;
import com.parenting.coach.ParentingCoach.data.WorkshopEvent;
import com.parenting.coach.ParentingCoach.email.EmailDetails;
import com.parenting.coach.ParentingCoach.email.EmailService;
import com.parenting.coach.ParentingCoach.service.ArticleService;
import com.parenting.coach.ParentingCoach.service.BookSessionService;
import com.parenting.coach.ParentingCoach.service.OfferService;
import com.parenting.coach.ParentingCoach.service.UsersService;
import com.parenting.coach.ParentingCoach.service.WorkshopEventService;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private UsersService usersService;
	@Autowired
	private OfferService offerService;
	@Autowired
	private WorkshopEventService workshopEventService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private BookSessionService bookSessionService;
	
	@GetMapping("home")
	public String welcome(Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		System.out.println("userId " + userId);
		List<Offer> offers = offerService.getAllOffer();
		List<Offer> offersForUser = offers.stream().filter(offer -> offer.getUser().getUserId().equals(userId))
				.collect(Collectors.toList());
		model.addAttribute("offers", offersForUser);
		
		
		List<WorkshopEvent> workshopEvents = workshopEventService.getAllWorkshopEvent();
		List<WorkshopEvent> workshopEventsForUser = workshopEvents.stream().filter(workshopEvent -> workshopEvent.getUser().getUserId().equals(userId))
				.collect(Collectors.toList());
		model.addAttribute("workshopEvents", workshopEventsForUser);
		
		List<Article> articles = articleService.getAllArticle();
		List<Article> articlesForUser = articles.stream().filter(article -> article.getUser().getUserId().equals(userId))
				.collect(Collectors.toList());

		model.addAttribute("articles", articlesForUser);
		
		
		return "home";
	}
	
	@GetMapping("addOffering")
	public String addOffering() {
		return "offering/add_offering";
	}
	
	@GetMapping("removeOffering")
	public String removeOffering(Model model) {
		List<Offer> offers = offerService.getAllOffer();
		model.addAttribute("offers", offers);
		return "offering/remove_offering";
	}
	
	@GetMapping("addWorkshop")
	public String addWorkshop() {
		return "workshop/add_workshop";
	}
	
	@GetMapping("removeWorkshop")
	public String removeWorkshop(Model model) {
		List<WorkshopEvent> workshopEvents = workshopEventService.getAllWorkshopEvent();
		model.addAttribute("workshopEvents", workshopEvents);
		return "workshop/remove_workshop";
	}
	
	@GetMapping("addArticle")
	public String addArticle() {
		return "article/add_article";
	}
	
	@GetMapping("removeArticle")
	public String removeArticle(Model model) {
		List<Article> articles = articleService.getAllArticle();
		model.addAttribute("articles", articles);
		return "article/remove_article";
	}
	
	@GetMapping("bookService")
	public String bookService(@RequestParam(value = "offerId") String offerId, Model model) {
		Offer offer = offerService.getOffer(Integer.parseInt(offerId));
		int duration = offer.getDuration();
		Duration sessionLength = Duration.ofMinutes(Long.valueOf("" + duration));
		LocalDateTime startDateTime = LocalDateTime.now();
		startDateTime = startDateTime.minusMinutes(startDateTime.getMinute()).plusHours(1l);
		LocalDateTime endDateTime = startDateTime.plusDays(1);

		model.addAttribute("service", offer.getOfferName());
		model.addAttribute("serviceDescription", offer.getOfferDescription());
		List<SessionInterval> sessionIntervalList = new ArrayList<>();
		List<BookSession> occupiedBookSessions = bookSessionService.getAllBookSessionForOffer(offer);
		for (LocalDateTime localDateTime = startDateTime; localDateTime.isBefore(endDateTime); localDateTime 
				= localDateTime.plusMinutes(duration)) {
			SessionInterval sessionInterval = new SessionInterval();
			sessionInterval.setEndDateTime(localDateTime.plusMinutes(duration - 1));
			sessionInterval.setStartDateTime(localDateTime);
			boolean isDurationAlreadyTaken = false;
			for (BookSession bookSession : occupiedBookSessions) {
				if (bookSession.getStartTime().isEqual(localDateTime)) {
					isDurationAlreadyTaken = true;
					break;
				} else if (bookSession.getStartTime().isAfter(localDateTime)
						&& bookSession.getStartTime().isBefore(localDateTime.plusMinutes(duration - 1))) {
					isDurationAlreadyTaken = true;
					break;
				}

			}
			if (!isDurationAlreadyTaken) {
				sessionIntervalList.add(sessionInterval);
			}
		}

		model.addAttribute("sessionIntervalList", sessionIntervalList);
		return "book/book_service";
	}
	
	@GetMapping("registerWorkshop")
	public String registerWorkshop(@RequestParam(value = "workshopEventId") String workshopEventId, Model model) {
		WorkshopEvent workshopEvent = workshopEventService.getWorkshopEvent(Integer.parseInt(workshopEventId));
		model.addAttribute("workshopEvent", workshopEvent);
		model.addAttribute("workshopEventStart", workshopEvent.getEventDateTime());
		model.addAttribute("workshopEventEnd",
				workshopEvent.getEventDateTime().plusMinutes(workshopEvent.getDuration()));
		return "book/register_workshop";
	}
	
	@GetMapping("sendMail")
	public String sendMail(Model model) {
		EmailDetails emailDetails = new EmailDetails();
		emailDetails.setSubject("test subject");
		emailDetails.setRecipient("purohit.munish3@gmail.com");
		emailDetails.setMsgBody("Test message body ");
		String response = emailService.sendSimpleMail(emailDetails);
		System.out.println("response " + response);
		
		return "home";
	}
}
