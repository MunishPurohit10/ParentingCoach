package com.parenting.coach.ParentingCoach.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class WorkShopImages {

    @EmbeddedId
    private WorkShopImagesId id;

    @JsonProperty("creation_date")
    private LocalDateTime creationDate;

    @JsonProperty("update_date")
    private LocalDateTime updateDate;

    @ManyToOne
    @MapsId("workShopId")
    @JoinColumn(name = "workshop_id")
    private WorkshopEvent workshop;

    @ManyToOne
    @MapsId("imageId")
    @JoinColumn(name = "image_id")
    private Image image;

    // Getters and Setters
}
