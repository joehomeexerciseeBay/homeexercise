package com.joe.homeexercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joe.homeexercise.service.ItemEligibilityService;

@RestController
public class ItemEligibilityController {

	@Autowired
	private ItemEligibilityService eligibilityService;

	
	@GetMapping("/itemeligible")
	public ResponseEntity<String> isItemEligible(@RequestParam(value = "itemname") String itemName,
			@RequestParam(value = "sellername") String sellerName,
			@RequestParam(value = "categoryid") Integer categoryId,
			@RequestParam(value = "price") Double minPrice)
	{
		if(eligibilityService.isItemEligible(sellerName, categoryId, minPrice))
			return ResponseEntity.ok(itemName+" is eligible for the new eBay shipping program");
		return ResponseEntity.ok(itemName+" is not eligible for the new eBay shipping program");
	}

}
