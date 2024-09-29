package com.parenting.coach.ParentingCoach.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.parenting.coach.ParentingCoach.constant.MessageConstants;
import com.parenting.coach.ParentingCoach.data.Article;
import com.parenting.coach.ParentingCoach.data.ArticleImages;
import com.parenting.coach.ParentingCoach.data.ArticleImagesId;
import com.parenting.coach.ParentingCoach.data.Image;
import com.parenting.coach.ParentingCoach.data.WorkShopImages;
import com.parenting.coach.ParentingCoach.data.WorkShopImagesId;
import com.parenting.coach.ParentingCoach.data.WorkshopEvent;
import com.parenting.coach.ParentingCoach.service.ArticleImagesService;
import com.parenting.coach.ParentingCoach.service.ArticleService;
import com.parenting.coach.ParentingCoach.service.ImageService;
import com.parenting.coach.ParentingCoach.service.WorkShopImagesService;
import com.parenting.coach.ParentingCoach.service.WorkshopEventService;

import jakarta.validation.constraints.NotBlank;

@Controller
public class ImageController extends BaseController {
	@Autowired
	private ImageService imageService;
	@Autowired
	private WorkshopEventService workshopEventService;
	@Autowired
	private WorkShopImagesService workShopImagesService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleImagesService articleImagesService;
	
	@PostMapping(value = "uploadImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String addImageProfile(@NotBlank @RequestParam(value = "imageName") String imageName,
			@RequestPart("file") MultipartFile file, Model model) {
		Image image = new Image();
		image.setCreationDate(LocalDateTime.now());
		image.setUpdateDate(LocalDateTime.now());
		image.setImageName(imageName);
		try {
			image.setImage(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imageService.addImage(image);
		model.addAttribute(MessageConstants.SUCCESS_MESSAGES, MessageConstants.IMAGE_UPLOAD_SUCCESSFUL);
		return "forward:home";
	}
	
	
	@GetMapping("associateImageToWorkshopEvent")
	public String associateImageToWorkshopEvent(
			@NotBlank @RequestParam(value = "workshopEventId") String workshopEventId,
			@NotBlank @RequestParam(value = "imageId") String imageId, Model model) {
		WorkshopEvent workshopEvent = workshopEventService.getWorkshopEvent(Integer.parseInt(workshopEventId));

		Image image = imageService.getImage(Integer.parseInt(imageId));

		WorkShopImages workShopImages = new WorkShopImages();
		workShopImages.setCreationDate(LocalDateTime.now());
		workShopImages.setUpdateDate(LocalDateTime.now());
		workShopImages.setWorkshop(workshopEvent);
		workShopImages.setImage(image);
		WorkShopImagesId workShopImagesId = new WorkShopImagesId();
		workShopImagesId.setImageId(image.getImageId());
		workShopImagesId.setWorkShopId(workshopEvent.getWorkshopEventId());
		workShopImages.setId(workShopImagesId);
		workShopImagesService.addWorkShopImages(workShopImages);

		model.addAttribute(MessageConstants.SUCCESS_MESSAGES, MessageConstants.IMAGE_ASSOCIATION_WITH_WORKSHOP_SUCCESSFUL);

		return "forward:home";
	}
	
	@GetMapping("associateImageToArticle")
	public String associateImageToArticle(@NotBlank @RequestParam(value = "articleId") String articleId,
			@NotBlank @RequestParam(value = "imageId") String imageId, Model model) {
		Article article = articleService.getArticle(Integer.parseInt(articleId));
		Image image = imageService.getImage(Integer.parseInt(imageId));

		ArticleImages articleImages = new ArticleImages();
		articleImages.setCreationDate(LocalDateTime.now());
		articleImages.setUpdateDate(LocalDateTime.now());
		articleImages.setArticle(article);
		articleImages.setImage(image);
		ArticleImagesId articleImagesId = new ArticleImagesId();
		articleImagesId.setArticleId(article.getArticleId());
		articleImagesId.setImageId(image.getImageId());
		articleImages.setId(articleImagesId);
		articleImagesService.addArticleImages(articleImages);

		model.addAttribute(MessageConstants.SUCCESS_MESSAGES, MessageConstants.IMAGE_ASSOCIATION_WITH_ARTICLE_SUCCESSFUL);
		
		return "forward:home";
	}
	
	@Override
	public String viewName() {
		return "image/add_new_image";
	}
	
	public String missingServletRequestViewName() {
		return "image/attach_image_to_workshop_event";
	}
}
