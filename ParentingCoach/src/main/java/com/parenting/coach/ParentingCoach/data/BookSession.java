package com.parenting.coach.ParentingCoach.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class BookSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("bookSession_id")
    private Long bookSessionId;

    @ManyToOne
    @JoinColumn(name = "offer_Id")
    @JsonProperty("offer")
    private Offer offer;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    @JsonProperty("user")
    private Users user;

    @JsonProperty("start_Time")
    private LocalDateTime startTime;

    @JsonProperty("end_Time")
    private LocalDateTime endTime;

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
