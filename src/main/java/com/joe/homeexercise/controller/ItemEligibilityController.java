package com.joe.homeexercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joe.homeexercise.repository.SellerRepository;

@RestController
public class ItemEligibilityController {
	@Autowired
	private SellerRepository sellerRepository;
	@GetMapping("/seller")
	public boolean isSellerEligible(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		return sellerRepository.findBySellerName(name)==null?false:true;
	}

}
