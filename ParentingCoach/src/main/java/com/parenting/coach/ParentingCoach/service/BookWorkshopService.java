package com.parenting.coach.ParentingCoach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parenting.coach.ParentingCoach.data.BookWorkshop;
import com.parenting.coach.ParentingCoach.data.BookWorkshopRepository;

@Service
public class BookWorkshopService {
	@Autowired
	private BookWorkshopRepository bookWorkshopRepository;
	
	public List<BookWorkshop> getAllBookWorkshop() {
		return bookWorkshopRepository.findAll();
	}
	
	public BookWorkshop getBookWorkshop(int bookWorkshopId) {
		 return bookWorkshopRepository.findById(bookWorkshopId).orElse(null);
	}
	
	public BookWorkshop addBookWorkshop(BookWorkshop bookWorkshop) {
		return bookWorkshopRepository.save(bookWorkshop);
	}
	
	public void deleteBookWorkshop(int bookWorkshopId) {
		bookWorkshopRepository.deleteById(bookWorkshopId);
	}
	
	public void updateBookWorkshop(BookWorkshop bookWorkshop) {
		
		bookWorkshopRepository.save(bookWorkshop);
	}
}
