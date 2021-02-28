package com.joe.homeexercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joe.homeexercise.model.ProgramEntity;
import com.joe.homeexercise.repository.CategoryRepository;
import com.joe.homeexercise.repository.PriceRepository;
import com.joe.homeexercise.repository.ProgramRepository;
import com.joe.homeexercise.repository.SellerRepository;
import com.joe.homeexercise.service.ItemEligibilityService;

@RestController
public class ItemEligibilityController {
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private ProgramRepository programRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private PriceRepository priceRepository;
	@Autowired
	private ItemEligibilityService eligibilityService;
	@GetMapping("/seller")
	private boolean isSellerEligible(@RequestParam(value = "sellername", defaultValue = "World") String sellerName,
			@RequestParam(value = "programname", defaultValue = "remote location shipping program") String programName)
	{
		ProgramEntity program = programRepository.findByProgramNameAndActiveInd(programName,"Y");
		if(null!=program)
		return sellerRepository.findBySellerName(sellerName.toLowerCase())==null?false:true;
		return false;
	}
	
	@GetMapping("/category")
	private boolean isCategoryEligible(@RequestParam(value = "categoryid") Integer categoryId)
	{
		
		return categoryRepository.findByCategoryId(categoryId)==null?false:true;
		
	}
	
	@GetMapping("/price")
	private boolean isItemPriceGreaterThanMinimumPrice(@RequestParam(value = "itemprice") Double itemPrice)
	{
		
		return priceRepository.findByMinPriceLessThanEqual(itemPrice)==null?false:true;
		
	}
	
	@GetMapping("/itemeligible")
	public ResponseEntity<String> isItemEligible(@RequestParam(value = "itemname") String itemName,
			@RequestParam(value = "sellername") String sellerName,
			@RequestParam(value = "categoryid") Integer categoryId,
			@RequestParam(value = "price") Double minPrice)
	{
		if(eligibilityService.isItemEligible(sellerName, categoryId, minPrice))
			return ResponseEntity.ok("Item "+itemName+" is eligible for the new eBay shipping program");
		return ResponseEntity.ok("Item "+itemName+" is not eligible for the new eBay shipping program");
	}

}
