package com.parenting.coach.ParentingCoach.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class WorkshopEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("workshop_event_id")
    private Long workshopEventId;

	@JsonProperty("workshop_name")
    private String workshopName;

    @JsonProperty("workshop_description")
    private String workshopDescription;

    @JsonProperty("event_date_time")
    private LocalDateTime eventDateTime;

    @JsonProperty("duration")
    private Integer duration;
    
    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("creation_date")
    private LocalDateTime creationDate;

    @JsonProperty("update_date")
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonProperty("user_id")
    private Users user;
}
