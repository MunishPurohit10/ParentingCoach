package com.parenting.coach.ParentingCoach.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parenting.coach.ParentingCoach.data.BookSession;
import com.parenting.coach.ParentingCoach.data.BookSessionRepository;
import com.parenting.coach.ParentingCoach.data.Offer;

@Service
public class BookSessionService {
	@Autowired
	private BookSessionRepository bookSessionRepository;
	
	public List<BookSession> getAllBookSession() {
		return bookSessionRepository.findAll();
	}
	
	public List<BookSession> getAllBookSessionForOffer(Offer offer) {
		return bookSessionRepository.findAll().stream().filter(bookSession -> bookSession.getOffer().equals(offer))
				.collect(Collectors.toList());
	}
	
	public BookSession getBookSession(int bookSessionId) {
		 return bookSessionRepository.findById(bookSessionId).orElse(null);
	}
	
	public BookSession addBookSession(BookSession bookSession) {
		return bookSessionRepository.save(bookSession);
	}
	
	public void deleteBookSession(int bookSessionId) {
		bookSessionRepository.deleteById(bookSessionId);
	}
	
	public void updateBookSession(BookSession bookSession) {
		
		bookSessionRepository.save(bookSession);
	}
}
