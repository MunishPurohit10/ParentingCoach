package com.parenting.coach.ParentingCoach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parenting.coach.ParentingCoach.data.Image;
import com.parenting.coach.ParentingCoach.data.ImageRepository;


@Service
public class ImageService {
	@Autowired
	private ImageRepository imageRepository;
	
	public List<Image> getAllImage() {
		return imageRepository.findAll();
	}
	
	public Image getImage(int imageId) {
		 return imageRepository.findById(imageId).orElse(null);
	}
	
	public Image addImage(Image image) {
		return imageRepository.save(image);
	}
	
	public void deleteImage(int imageId) {
		imageRepository.deleteById(imageId);
	}
	
	public void updateImage(Image image) {
		
		imageRepository.save(image);
	}
}
