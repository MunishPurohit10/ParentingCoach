package com.parenting.coach.ParentingCoach.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class WorkshopEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("workshop_event_id")
    private Long workshopEventId;

	@JsonProperty("workshop_name")
    private String workshopName;

	@Length(min = 3, max = 1000)
    @JsonProperty("workshop_description")
    private String workshopDescription;

    @JsonProperty("event_date_time")
    private LocalDateTime eventDateTime;

    @JsonProperty("duration")
    private Integer duration;
    
    @JsonProperty("capacity")
    private Integer capacity;
    
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
