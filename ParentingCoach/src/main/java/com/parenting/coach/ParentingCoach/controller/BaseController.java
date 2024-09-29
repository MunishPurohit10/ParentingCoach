package com.parenting.coach.ParentingCoach.controller;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.parenting.coach.ParentingCoach.constant.MessageConstants;

import jakarta.validation.ConstraintViolationException;

@Validated
public abstract class BaseController {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/error");
		
		return mav;
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView handleConstraintViolationError(ConstraintViolationException constraintViolationException,
			Model model) {
		System.out.println("model.asMap().size() " + model.asMap().size());
		
		ModelAndView mav = new ModelAndView();
		model.asMap().entrySet().forEach(entity -> System.out.println("key " + entity.getKey() + " value " + entity.getValue()));

		mav.addObject(MessageConstants.ERROR_MESSAGES, constraintViolationException.getMessage());
		mav.setViewName(viewName());
		
		return mav;
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingServletRequestParameterError(MissingServletRequestParameterException missingServletRequestParameterException,
			Model model) {
		ModelAndView mav = new ModelAndView();
		System.out.println("model.asMap().size() " + model.asMap().size());
		model.asMap().entrySet().forEach(entity -> System.out.println("key " + entity.getKey() + " value " + entity.getValue()));
		mav.addObject(MessageConstants.ERROR_MESSAGES, missingServletRequestParameterException.getMessage());
		mav.setViewName(missingServletRequestViewName());
		
		return mav;
	}
	
	
	public abstract String viewName();
	
	public String missingServletRequestViewName() {
		return "forward:home";
	}
}
