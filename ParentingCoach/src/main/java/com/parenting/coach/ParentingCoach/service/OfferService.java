package com.parenting.coach.ParentingCoach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parenting.coach.ParentingCoach.data.Offer;
import com.parenting.coach.ParentingCoach.data.OfferRepository;


@Service
public class OfferService {
	@Autowired
	private OfferRepository offerRepository;
	
	public List<Offer> getAllOffer() {
		return offerRepository.findAll();
	}
	
	public Offer getOffer(int offerId) {
		 return offerRepository.findById(offerId).orElse(null);
	}
	
	public Offer addOffer(Offer offer) {
		return offerRepository.save(offer);
	}
	
	public void deleteOffer(int offerId) {
		offerRepository.deleteById(offerId);
	}
	
	public void updateOffer(Offer offer) {
		
		offerRepository.save(offer);
	}
}
