package com.parenting.coach.ParentingCoach.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Login {

    @Id
    @JsonProperty("login_id")
    private Long loginId;

    @JsonProperty("login_name")
    private String loginName;
    
    @JsonProperty("password")
    private String password;

    @JsonProperty("creation_date")
    private LocalDateTime creationDate;

    @JsonProperty("update_date")
    private LocalDateTime updateDate;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private Users users;

    // Getters and Setters
}
