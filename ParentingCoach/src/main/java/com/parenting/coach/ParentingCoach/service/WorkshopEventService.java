package com.parenting.coach.ParentingCoach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parenting.coach.ParentingCoach.data.WorkshopEvent;
import com.parenting.coach.ParentingCoach.data.WorkshopEventRepository;


@Service
public class WorkshopEventService {
	@Autowired
	private WorkshopEventRepository workshopEventRepository;
	
	public List<WorkshopEvent> getAllWorkshopEvent() {
		return workshopEventRepository.findAll();
	}
	
	public WorkshopEvent getWorkshopEvent(int workshopEventId) {
		 return workshopEventRepository.findById(workshopEventId).orElse(null);
	}
	
	public WorkshopEvent addWorkshopEvent(WorkshopEvent workshopEvent) {
		return workshopEventRepository.save(workshopEvent);
	}
	
	public void deleteWorkshopEvent(int workshopEventId) {
		workshopEventRepository.deleteById(workshopEventId);
	}
	
	public void updateWorkshopEvent(WorkshopEvent workshopEvent) {
		
		workshopEventRepository.save(workshopEvent);
	}
}
