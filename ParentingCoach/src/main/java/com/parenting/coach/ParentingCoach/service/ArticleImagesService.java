package com.parenting.coach.ParentingCoach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parenting.coach.ParentingCoach.data.ArticleImages;
import com.parenting.coach.ParentingCoach.data.ArticleImagesId;
import com.parenting.coach.ParentingCoach.data.ArticleImagesRepository;


@Service
public class ArticleImagesService {
	@Autowired
	private ArticleImagesRepository articleImagesRepository;
	
	public List<ArticleImages> getAllArticleImages() {
		return articleImagesRepository.findAll();
	}
	
	public ArticleImages getArticleImages(ArticleImagesId articleImagesId) {
		 return articleImagesRepository.findById(articleImagesId).orElse(null);
	}
	
	public ArticleImages addArticleImages(ArticleImages articleImages) {
		return articleImagesRepository.save(articleImages);
	}
	
	public void deleteArticleImages(ArticleImagesId articleImagesId) {
		articleImagesRepository.deleteById(articleImagesId);
	}
	
	public void updateArticleImages(ArticleImages articleImages) {
		
		articleImagesRepository.save(articleImages);
	}
}
