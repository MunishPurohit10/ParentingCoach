package com.parenting.coach.ParentingCoach.data.wrapper;

import com.parenting.coach.ParentingCoach.data.WorkshopEvent;

import lombok.Data;

@Data
public class WorkshopEventWrapper {
	private WorkshopEvent workshopEvent;
	private String encodedImageStr;
}
