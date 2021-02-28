package com.joe.homeexercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joe.homeexercise.HomeExerciseTrace;
import com.joe.homeexercise.service.ItemEligibilityService;
import com.joe.homeexercise.util.EligibilityEnum;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("api/item")
public class ItemEligibilityController {

	@Autowired
	private ItemEligibilityService eligibilityService;

	@Operation(summary="Check if an item is eligible for the new eBay shipping program")
	@GetMapping("/eligible")
	@HomeExerciseTrace
	public ResponseEntity<String> isItemEligible(@Parameter(description="Name of the item to be shipped")@RequestParam(value = "itemname") String itemName,
			@Parameter(description="Name of the seller shipping the item")@RequestParam(value = "sellername") String sellerName,
			@Parameter(description="Identifier of the category to which the item belongs")@RequestParam(value = "categoryid") Integer categoryId,
			@Parameter(description="Price of the item in USD")@RequestParam(value = "price") Double minPrice)
	{
		StringBuilder sb = new StringBuilder();
		List<EligibilityEnum>  inEligibleArray= eligibilityService.isItemEligible(sellerName, categoryId, minPrice);
		if(inEligibleArray.size()==0)
			return ResponseEntity.ok(itemName+" is eligible for the new eBay shipping program");
		sb.append(itemName+" is not eligible for the new eBay shipping program because \n");
		for(EligibilityEnum inEligible:inEligibleArray)
		{
			
			if(inEligible.equals(EligibilityEnum.SELLER))
			{
				sb.append(sellerName+" is not enrolled to the new eBay shipping program. Please contact eBay to enroll seller. \n");
				continue;
			}
			if(inEligible.equals(EligibilityEnum.CATEGORY))
			{
				sb.append(categoryId+" is not an approved category for the new eBay shipping program. Please contact eBay to add your category to approved list. \n");
				continue;
			}
			if(inEligible.equals(EligibilityEnum.PRICE))
			{
				sb.append(minPrice+" is less than minimum price for the new eBay shipping program, Please contact eBay to get minimum price. \n");
				continue;
			}
			
		}
		return ResponseEntity.ok(sb.toString());
	}

}
