package com.parenting.coach.ParentingCoach.controller;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SessionInterval {
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
}
