package com.parenting.coach.ParentingCoach.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class BookWorkshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("bookWorkshop_id")
    private Long bookWorkshopId;

    @ManyToOne
    @JoinColumn(name = "workshop_Id")
    @JsonProperty("workshop")
    private WorkshopEvent workshop;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    @JsonProperty("user")
    private Users user;

    @JsonProperty("creation_Date")
    @Column(updatable = false)
    private LocalDateTime creationDate;

    @JsonProperty("update_Date")
    private LocalDateTime updateDate;

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = LocalDateTime.now();
    }

    // Getters and Setters
}