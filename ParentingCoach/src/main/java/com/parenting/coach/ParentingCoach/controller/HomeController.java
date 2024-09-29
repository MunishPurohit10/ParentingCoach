package com.parenting.coach.ParentingCoach.controller;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parenting.coach.ParentingCoach.data.Article;
import com.parenting.coach.ParentingCoach.data.ArticleImages;
import com.parenting.coach.ParentingCoach.data.BookSession;
import com.parenting.coach.ParentingCoach.data.Image;
import com.parenting.coach.ParentingCoach.data.Offer;
import com.parenting.coach.ParentingCoach.data.Users;
import com.parenting.coach.ParentingCoach.data.WorkShopImages;
import com.parenting.coach.ParentingCoach.data.WorkshopEvent;
import com.parenting.coach.ParentingCoach.data.wrapper.ArticleWrapper;
import com.parenting.coach.ParentingCoach.data.wrapper.WorkshopEventWrapper;
import com.parenting.coach.ParentingCoach.email.EmailDetails;
import com.parenting.coach.ParentingCoach.email.EmailService;
import com.parenting.coach.ParentingCoach.service.ArticleImagesService;
import com.parenting.coach.ParentingCoach.service.ArticleService;
import com.parenting.coach.ParentingCoach.service.BookSessionService;
import com.parenting.coach.ParentingCoach.service.ImageService;
import com.parenting.coach.ParentingCoach.service.OfferService;
import com.parenting.coach.ParentingCoach.service.UsersService;
import com.parenting.coach.ParentingCoach.service.WorkShopImagesService;
import com.parenting.coach.ParentingCoach.service.WorkshopEventService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotBlank;

@Controller
public class HomeController extends BaseController {
	@Autowired
	private UsersService usersService;
	@Autowired
	private OfferService offerService;
	@Autowired
	private WorkshopEventService workshopEventService;
	@Autowired
	private WorkShopImagesService workShopImagesService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleImagesService articleImagesService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private BookSessionService bookSessionService;
	@Autowired
	private ImageService imageService;

	
	@GetMapping("home")
	public String welcome(Model model, HttpSession session) throws Exception {
		Long userId = (Long)session.getAttribute("userId");
		System.out.println("userId " + userId);
		Users users = usersService.getUser(Integer.parseInt(String.valueOf(userId)));
		String userType = users.getType();
		// TODO: If it is consultant or admin page filter the offer, workshops and article.
		// Else show all the offer, workshops and articles.
		
		// TODO: filter out offer that are expired, workshops that are expired and article that are expired.
		List<Offer> offers = offerService.getAllOffer();
		offers = offers.stream().filter(offer -> offer.getExpiryDateTime().isBefore(LocalDateTime.now()))
				.collect(Collectors.toList());
		if ("consultant".equalsIgnoreCase(userType) || "admin".equalsIgnoreCase(userType)) {
			offers = offers.stream().filter(offer -> offer.getUser().getUserId().equals(userId))
				.collect(Collectors.toList());
		}
		model.addAttribute("offers", offers);
		
		List<WorkshopEvent> workshopEvents = workshopEventService.getAllWorkshopEvent();
		workshopEvents = workshopEvents.stream()
				.filter(workshopevent -> workshopevent.getEventDateTime().isBefore(LocalDateTime.now()))
				.collect(Collectors.toList());
		if ("consultant".equalsIgnoreCase(userType) || "admin".equalsIgnoreCase(userType)) {
			workshopEvents = workshopEvents.stream().filter(workshopEvent -> workshopEvent.getUser().getUserId().equals(userId))
				.collect(Collectors.toList());
		}
		
		List<WorkshopEventWrapper> workshopEventWrappers = new ArrayList<>();
		List<WorkShopImages> workShopImagesList = workShopImagesService.getAllWorkShopImages();
		for (WorkshopEvent workshopEvent : workshopEvents) {
			Optional<Image> image = workShopImagesList.stream().filter(workShopImages -> workShopImages.getWorkshop()
					.getWorkshopEventId().equals(workshopEvent.getWorkshopEventId())).findAny()
					.map(WorkShopImages::getImage);
			WorkshopEventWrapper workshopEventWrapper = new WorkshopEventWrapper();
			workshopEventWrapper.setWorkshopEvent(workshopEvent);
			if (image.isPresent()) {
				workshopEventWrapper.setEncodedImageStr(Base64.encodeBase64String(image.get().getImage()));
			}
			workshopEventWrappers.add(workshopEventWrapper);
		}
		model.addAttribute("workshopEventWrappers", workshopEventWrappers);
		if (Objects.nonNull(workShopImagesList) && !workShopImagesList.isEmpty()) {
			model.addAttribute("image", Base64.encodeBase64String(workShopImagesList.get(0).getImage().getImage()));
		}
		
		List<Article> articles = articleService.getAllArticle();
		articles = articles.stream().filter(article -> article.getExpiryDate().isBefore(LocalDate.now()))
				.collect(Collectors.toList());
		if ("consultant".equalsIgnoreCase(userType) || "admin".equalsIgnoreCase(userType)) {
			articles = articles.stream().filter(article -> article.getUser().getUserId().equals(userId))
				.collect(Collectors.toList());
		}
		List<ArticleWrapper> articleWrappers = new ArrayList<>();
		List<ArticleImages> articleImagesList = articleImagesService.getAllArticleImages();
		for (Article article : articles) {
			Optional<Image> image = articleImagesList.stream().filter(articleImages -> articleImages.getArticle()
					.getArticleId().equals(article.getArticleId())).findAny()
					.map(ArticleImages::getImage);
			ArticleWrapper articleWrapper = new ArticleWrapper();
			articleWrapper.setArticle(article);
			if (image.isPresent()) {
				articleWrapper.setEncodedImageStr(Base64.encodeBase64String(image.get().getImage()));
			}
			articleWrappers.add(articleWrapper);
		}
		
		model.addAttribute("articleWrappers", articleWrappers);
		model.addAttribute("userType", userType);
		articleImagesService.getAllArticleImages();

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
	public String bookService(@NotBlank @RequestParam(value = "offerId") String offerId, Model model) {
		Offer offer = offerService.getOffer(Integer.parseInt(offerId));
		int duration = offer.getDuration();
		LocalDateTime startDateTime = LocalDateTime.now();
		startDateTime = startDateTime.minusMinutes(startDateTime.getMinute()).plusHours(1l);
		LocalDateTime endDateTime = startDateTime.plusDays(7);

		model.addAttribute("service", offer.getOfferName());
		model.addAttribute("offerId", offer.getOfferId());
		model.addAttribute("serviceDescription", offer.getOfferDescription());
		List<SessionInterval> sessionIntervalList = new ArrayList<>();
		List<BookSession> occupiedBookSessions = bookSessionService.getAllBookSessionForOffer(offer);
		for (LocalDateTime localDateTime = startDateTime; localDateTime.isBefore(endDateTime); localDateTime 
				= localDateTime.plusMinutes(duration)) {
			SessionInterval sessionInterval = new SessionInterval();
			LocalDateTime sessionEndTime = localDateTime.plusMinutes(duration - 1);
			sessionInterval.setEndDateTime(sessionEndTime);
			sessionInterval.setStartDateTime(localDateTime);
			if (localDateTime.getHour() < 8 || sessionEndTime.getHour() > 22
					|| localDateTime.getDayOfWeek().equals(DayOfWeek.SUNDAY)
					|| localDateTime.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
				continue;
			}
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
	public String registerWorkshop(@NotBlank @RequestParam(value = "workshopEventId") String workshopEventId, Model model) {
		WorkshopEvent workshopEvent = workshopEventService.getWorkshopEvent(Integer.parseInt(workshopEventId));
		model.addAttribute("workshopEvent", workshopEvent);
		model.addAttribute("workshopEventStart", workshopEvent.getEventDateTime());
		model.addAttribute("workshopEventEnd",
				workshopEvent.getEventDateTime().plusMinutes(workshopEvent.getDuration()));
		// TODO: Add the check for capacity
		
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
	
	@GetMapping("addImage")
	public String addImage(Model model) {
		List<Image> images = imageService.getAllImage();
		model.addAttribute("images", images);
		
		return "image/add_new_image";
	}
	
	@GetMapping("associateWorkshopEventToImage")
	public String associateWorkshopEventToImage(@NotBlank @RequestParam(value = "workshopEventId") String workshopEventId, Model model) {
		List<Image> images = imageService.getAllImage();
		model.addAttribute("workshopEventId", workshopEventId);
		model.addAttribute("images", images);
		
		return "image/attach_image_to_workshop_event";
	}
	
	@GetMapping("associateArticleToImage")
	public String associateArticleToImage(@RequestParam(value = "articleId") String articleId, Model model) {
		model.addAttribute("articleId", articleId);
		List<Image> images = imageService.getAllImage();
		model.addAttribute("images", images);
		
		return "image/attach_image_to_article";
	}
	
	@Override
	public String viewName() {
		return "home";
	}

}
