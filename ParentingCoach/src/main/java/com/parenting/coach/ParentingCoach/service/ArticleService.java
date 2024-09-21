package com.parenting.coach.ParentingCoach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parenting.coach.ParentingCoach.data.Article;
import com.parenting.coach.ParentingCoach.data.ArticleRepository;



@Service
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;
	
	public List<Article> getAllArticle() {
		return articleRepository.findAll();
	}
	
	public Article getArticle(int articleId) {
		 return articleRepository.findById(articleId).orElse(null);
	}
	
	public Article addArticle(Article article) {
		return articleRepository.save(article);
	}
	
	public void deleteArticle(int articleId) {
		articleRepository.deleteById(articleId);
	}
	
	public void updateArticle(Article article) {
		
		articleRepository.save(article);
	}
}
