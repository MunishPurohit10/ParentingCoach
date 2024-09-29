package com.parenting.coach.ParentingCoach.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("offer_id")
    private Long offerId;

	@JsonProperty("offer_name")
    private String offerName;

	@Length(min = 3, max = 1000)
    @JsonProperty("offer_description")
    private String offerDescription;

	@JsonProperty("expiry_date_time")
    private LocalDateTime expiryDateTime;

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

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", offerName=" + offerName + ", offerDescription=" + offerDescription
				+ ", expiryDateTime=" + expiryDateTime + ", isActive=" + isActive + ", creationDate=" + creationDate
				+ ", updateDate=" + updateDate + ", user=" + user + "]";
	}

}
