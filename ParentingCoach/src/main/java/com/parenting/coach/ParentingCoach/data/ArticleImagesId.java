package com.parenting.coach.ParentingCoach.data;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ArticleImagesId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long articleId;
    private Long imageId;
    public ArticleImagesId(Long articleId, Long imageId) {
		super();
		this.articleId = articleId;
		this.imageId = imageId;
	}
	
    public ArticleImagesId() {
    	
    }
    // Default constructor, Getters, Setters, equals(), and hashCode() methods
}
