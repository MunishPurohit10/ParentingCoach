package com.parenting.coach.ParentingCoach.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("article_id")
    private Long articleId;

	@JsonProperty("article_name")
    private String articleName;

    @JsonProperty("article_description")
    private String articleDescription;

    @JsonProperty("expiry_date")
    private LocalDate expiryDate;

    @JsonProperty("creation_date")
    private LocalDateTime creationDate;

    @JsonProperty("update_date")
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonProperty("user_id")
    private Users user;
}
