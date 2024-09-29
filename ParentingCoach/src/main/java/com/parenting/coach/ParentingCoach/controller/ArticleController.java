package com.parenting.coach.ParentingCoach.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parenting.coach.ParentingCoach.constant.MessageConstants;
import com.parenting.coach.ParentingCoach.data.Article;
import com.parenting.coach.ParentingCoach.data.Users;
import com.parenting.coach.ParentingCoach.service.ArticleService;
import com.parenting.coach.ParentingCoach.service.UsersService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotBlank;

@Controller
public class ArticleController extends BaseController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UsersService usersService;

	@GetMapping("confirmArticle")
	public String confirmOfferAdding(@NotBlank @RequestParam(value = "article_name") String articleName,
			@NotBlank @RequestParam(value = "article_description") String articleDescription,
			@NotBlank @RequestParam(value = "expiry_date") String expiryDate, Model model, HttpSession session) {
		Article article = new Article();
		article.setArticleDescription(articleDescription);
		article.setArticleName(articleName);
		article.setCreationDate(LocalDateTime.now());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'[[HH][:mm][:ss][.SSS]]");
		LocalDate expiryLocalDate = LocalDate.parse(expiryDate, formatter);
		article.setExpiryDate(expiryLocalDate);
		article.setUpdateDate(LocalDateTime.now());
		Long userId = (Long) session.getAttribute("userId");
		Users user = usersService.getUser(Integer.parseInt("" + userId));
		article.setUser(user);
		articleService.addArticle(article);

		model.addAttribute(MessageConstants.SUCCESS_MESSAGES, MessageConstants.ARTICLE_ADDED_SUCCESSFULLY);
		return "forward:home";
	}

	@GetMapping("deleteArticle")
	public String deleteOffer(@RequestParam(value = "articles") String[] articleIds, Model model) {
		for (String articleId : articleIds) {
			articleService.deleteArticle(Integer.valueOf(articleId));
		}
		model.addAttribute(MessageConstants.SUCCESS_MESSAGES, MessageConstants.ARTICLES_DELETED_SUCCESSFULLY);
		return "forward:home";
	}

	@Override
	public String viewName() {
		return "article/add_article";
	}
}
