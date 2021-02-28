package com.joe.homeexercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joe.homeexercise.service.ItemEligibilityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("api/item")
public class ItemEligibilityController {

	@Autowired
	private ItemEligibilityService eligibilityService;

	@Operation(summary="Check if an item is eligible for the new eBay shipping program")
	@GetMapping("/eligible")
	public ResponseEntity<String> isItemEligible(@Parameter(description="Name of the item to be shipped")@RequestParam(value = "itemname") String itemName,
			@Parameter(description="Name of the seller shipping the item")@RequestParam(value = "sellername") String sellerName,
			@Parameter(description="Identifier of the category to which the item belongs")@RequestParam(value = "categoryid") Integer categoryId,
			@Parameter(description="Price of the item in USD")@RequestParam(value = "price") Double minPrice)
	{
		if(eligibilityService.isItemEligible(sellerName, categoryId, minPrice))
			return ResponseEntity.ok(itemName+" is eligible for the new eBay shipping program");
		return ResponseEntity.ok(itemName+" is not eligible for the new eBay shipping program");
	}

}
