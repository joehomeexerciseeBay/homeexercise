package com.joe.homeexercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.joe.homeexercise.model.Category;
import com.joe.homeexercise.model.CategoryEntity;
import com.joe.homeexercise.model.Price;
import com.joe.homeexercise.model.PriceEntity;
import com.joe.homeexercise.model.ProgramEntity;
import com.joe.homeexercise.model.Seller;
import com.joe.homeexercise.model.SellerEntity;
import com.joe.homeexercise.repository.CategoryRepository;
import com.joe.homeexercise.repository.PriceRepository;
import com.joe.homeexercise.repository.ProgramRepository;
import com.joe.homeexercise.repository.SellerRepository;

import io.swagger.v3.oas.annotations.ExternalDocumentation;



@RestController
public class AdminController {
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	ProgramRepository programRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	PriceRepository priceRepository;
	
	@PostMapping(value="/enrollsellertoshippingprogram",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExternalDocumentation(description = "Enroll a seller to new eBay shipping program.")
	public ResponseEntity<String> addSellerToProgram(@RequestBody Seller seller)
	{
		ProgramEntity program = programRepository.findByProgramNameAndActiveInd("remote location shipping program","Y");
		if(null==sellerRepository.findBySellerNameAndProgramId(seller.getUserName().toLowerCase(),program.getProgramId()))
		sellerRepository.saveAndFlush(new SellerEntity(seller.getUserName().toLowerCase(),program.getProgramId()));
		return ResponseEntity.ok(seller.getUserName()+" is enrolled to the new eBay shipping program");
	}
	
	@DeleteMapping(value="/dischargesellerfromshippingprogram",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExternalDocumentation(description = "Discharge a seller from new eBay shipping program.")
	public ResponseEntity<String> dischargeSellerFromProgram(@RequestBody Seller seller)
	{
		ProgramEntity program = programRepository.findByProgramNameAndActiveInd("remote location shipping program","Y");
		if(null!=sellerRepository.findBySellerNameAndProgramId(seller.getUserName().toLowerCase(),program.getProgramId()))
		sellerRepository.deleteById(sellerRepository.findBySellerNameAndProgramId(seller.getUserName().toLowerCase(),program.getProgramId()).getSellerId());
		//sellerRepository.delete(new SellerEntity(seller.getUserName().toLowerCase(),program.getProgramId()));
		return ResponseEntity.ok(seller.getUserName()+" is discharged from the new eBay shipping program");
	}
	
	@PostMapping(value="/addcategorytopreapprovedlist",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExternalDocumentation(description = "Add a category to the list of preapproved categories.")
	public ResponseEntity<String> addCategoryToApprovedList(@RequestBody Category category)
	{
		//ProgramEntity program = programRepository.findByProgramNameAndActiveInd("remote location shipping program","Y");
		categoryRepository.saveAndFlush(new CategoryEntity(category.getCategoryName().toLowerCase(),category.getDescription()));
		return ResponseEntity.ok(category.getCategoryName()+" is included to the list of preapproved categories.");
	}
	
	@PostMapping(value="/changeminimumprice",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExternalDocumentation(description = "Change minimum price")
	public ResponseEntity<String> updateMinPrice(@RequestBody Price price)
	{
		//ProgramEntity program = programRepository.findByProgramNameAndActiveInd("remote location shipping program","Y");
		priceRepository.deleteAll();
		priceRepository.saveAndFlush(new PriceEntity(price.getMinimumPrice()));
		return ResponseEntity.ok("Minimum price is changed to "+price.getMinimumPrice());
	}

}
