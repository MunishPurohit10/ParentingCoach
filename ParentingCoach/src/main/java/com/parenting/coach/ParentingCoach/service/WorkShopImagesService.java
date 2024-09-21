package com.parenting.coach.ParentingCoach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parenting.coach.ParentingCoach.data.WorkShopImages;
import com.parenting.coach.ParentingCoach.data.WorkShopImagesId;
import com.parenting.coach.ParentingCoach.data.WorkShopImagesRepository;


@Service
public class WorkShopImagesService {
	@Autowired
	private WorkShopImagesRepository workShopImagesRepository;
	
	public List<WorkShopImages> getAllWorkShopImages() {
		return workShopImagesRepository.findAll();
	}
	
	public WorkShopImages getWorkShopImages(WorkShopImagesId workShopImagesId) {
		 return workShopImagesRepository.findById(workShopImagesId).orElse(null);
	}
	
	public WorkShopImages addWorkShopImages(WorkShopImages workShopImages) {
		return workShopImagesRepository.save(workShopImages);
	}
	
	public void deleteWorkShopImages(WorkShopImagesId workShopImagesId) {
		workShopImagesRepository.deleteById(workShopImagesId);
	}
	
	public void updateWorkShopImages(WorkShopImages workShopImages) {
		
		workShopImagesRepository.save(workShopImages);
	}
}
