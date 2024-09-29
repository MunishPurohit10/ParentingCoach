package com.parenting.coach.ParentingCoach.data.wrapper;

import com.parenting.coach.ParentingCoach.data.Article;

import lombok.Data;

@Data
public class ArticleWrapper {
	private Article article;
	private String encodedImageStr;
}
