package com.joe.homeexercise.controller;

import java.util.Currency;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.joe.homeexercise.HomeExerciseTrace;
import com.joe.homeexercise.model.Category;
import com.joe.homeexercise.model.CategoryEntity;
import com.joe.homeexercise.model.Price;
import com.joe.homeexercise.model.PriceEntity;
import com.joe.homeexercise.model.Seller;
import com.joe.homeexercise.model.SellerEntity;
import com.joe.homeexercise.repository.CategoryRepository;
import com.joe.homeexercise.repository.PriceRepository;
import com.joe.homeexercise.repository.ProgramRepository;
import com.joe.homeexercise.repository.SellerRepository;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;



@RestController
@RequestMapping("api/admin")
public class AdminController {
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	ProgramRepository programRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	PriceRepository priceRepository;
	
	@Operation(summary="Get list of all sellers enrolled to new eBay shipping program")
	@GetMapping(value="/getallsellers",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExternalDocumentation(description = "Get all sellers enrolled to new eBay shipping program")
	@HomeExerciseTrace
	public List<SellerEntity> getAllSellers()
	{
		return sellerRepository.findAll();
	}
	
	@Operation(summary="Enroll a seller to new eBay shipping program")
	@PostMapping(value="/enrollsellertoshippingprogram",produces=MediaType.TEXT_HTML_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExternalDocumentation(description = "Enroll a seller to new eBay shipping program.")
	@HomeExerciseTrace
	public ResponseEntity<String> addSellerToProgram(@RequestBody Seller seller)
	{
		if(null==sellerRepository.findBySellerNameIgnoreCase(seller.getSellerName()))
		sellerRepository.saveAndFlush(new SellerEntity(seller.getSellerName()));
		return ResponseEntity.ok(seller.getSellerName()+" is enrolled to the new eBay shipping program");
	}
	
	@Operation(summary="Discharge a seller from new eBay shipping program.")
	@DeleteMapping(value="/dischargesellerfromshippingprogram",produces=MediaType.TEXT_HTML_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExternalDocumentation(description = "Discharge a seller from new eBay shipping program.")
	@HomeExerciseTrace
	public ResponseEntity<String> dischargeSellerFromProgram(@RequestBody Seller seller)
	{
		if(null!=sellerRepository.findBySellerNameIgnoreCase(seller.getSellerName()))
		sellerRepository.deleteById(sellerRepository.findBySellerNameIgnoreCase(seller.getSellerName()).getSellerId());
		return ResponseEntity.ok(seller.getSellerName()+" is discharged from the new eBay shipping program");
	}
	
	@Operation(summary="Add a category to new eBay shipping program.")
	@PostMapping(value="/addcategorytoshippingprogram",produces=MediaType.TEXT_HTML_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExternalDocumentation(description = "Add a category to new eBay shipping program.")
	@HomeExerciseTrace
	public ResponseEntity<String> addCategoryToApprovedList(@RequestBody Category category)
	{
		CategoryEntity entity = categoryRepository.findByCategoryNameIgnoreCase(category.getCategoryName());
		if(null==entity)
		entity = categoryRepository.saveAndFlush(new CategoryEntity(category.getCategoryName()));
		return ResponseEntity.ok(category.getCategoryName()+" is included to the list of preapproved categories. The identifier for "+category.getCategoryName()+" is "+entity.getCategoryId());
	}
	
	@Operation(summary="Get list of all preapproved categories for new eBay shipping program")
	@GetMapping(value="/getallpreapprovedcategories",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExternalDocumentation(description = "Get all preapproved categories")
	@HomeExerciseTrace
	public List<CategoryEntity> getAllPreApprovedCategories()
	{
		return categoryRepository.findAll();
	}
	
	@Operation(summary="Delete category from new eBay shipping program.")
	@DeleteMapping(value="/deletecategoryfromshippingprogram",produces=MediaType.TEXT_HTML_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExternalDocumentation(description = "Delete category from new eBay shipping program.")
	@HomeExerciseTrace
	public ResponseEntity<String> deleteCategoryFromShippingProgram(@RequestBody Category category)
	{
		if(null!=categoryRepository.findByCategoryNameIgnoreCase(category.getCategoryName()))
			categoryRepository.deleteById(categoryRepository.findByCategoryNameIgnoreCase(category.getCategoryName()).getCategoryId());
		return ResponseEntity.ok(category.getCategoryName()+" is deleted from the new eBay shipping program");
	}
	
	@Operation(summary="Get Minimum price for an item to be eligible for new eBay shipping program.")
	@GetMapping(value="/getminimumprice",produces=MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	@ExternalDocumentation(description = "Get Minimum price for an item to be eligible for new eBay shipping program")
	@HomeExerciseTrace
	public ResponseEntity<String> getMinimumPrice()
	{
		return ResponseEntity.ok("Minumum price for an item to be qualified for new eBay shipping program is "+Currency.getInstance(Locale.US).getSymbol(Locale.US)+""+ priceRepository.findAll().get(0).getMinPrice());
	}
	
	@Operation(summary="Change minimum price for an item to be eligible for new eBay shipping program. Item price is in USD")
	@PostMapping(value="/changeminimumprice",produces=MediaType.TEXT_HTML_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExternalDocumentation(description = "Change minimum price for an item to be eligible for new eBay shipping program")
	@HomeExerciseTrace
	public ResponseEntity<String> updateMinPrice(@RequestBody Price price)
	{
		priceRepository.deleteAll();
		priceRepository.saveAndFlush(new PriceEntity(price.getMinimumPrice()));
		return ResponseEntity.ok("Minimum price is changed to "+Currency.getInstance(Locale.getDefault()).getSymbol(Locale.getDefault())+""+price.getMinimumPrice());
	}

}
