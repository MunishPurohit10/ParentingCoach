package com.parenting.coach.ParentingCoach.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ArticleImages {

    @EmbeddedId
    private ArticleImagesId id;
    
	public ArticleImages(ArticleImagesId id, LocalDateTime creationDate, LocalDateTime updateDate, Article article,
			Image image) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.article = article;
		this.image = image;
	}

	public ArticleImages() {
		
	}
	@JsonProperty("creation_date")
    private LocalDateTime creationDate;

    @JsonProperty("update_date")
    private LocalDateTime updateDate;

    @ManyToOne
    @MapsId("articleId")
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @MapsId("imageId")
    @JoinColumn(name = "image_id")
    private Image image;

    // Getters and Setters
}