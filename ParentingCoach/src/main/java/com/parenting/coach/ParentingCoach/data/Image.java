package com.parenting.coach.ParentingCoach.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("image_id")
    private Long imageId;

    @Lob
    @Column(columnDefinition = "blob")
    @JsonProperty("image")
    private byte[] image;

    @JsonProperty("image_name")
    private String imageName;
    
    @JsonProperty("creation_date")
    private LocalDateTime creationDate;

    @JsonProperty("update_date")
    private LocalDateTime updateDate;

    // Getters and Setters
}

