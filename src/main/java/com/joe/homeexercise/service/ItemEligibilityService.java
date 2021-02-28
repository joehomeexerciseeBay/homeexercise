/**
 * 
 */
package com.joe.homeexercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.homeexercise.model.ProgramEntity;
import com.joe.homeexercise.repository.CategoryRepository;
import com.joe.homeexercise.repository.PriceRepository;
import com.joe.homeexercise.repository.ProgramRepository;
import com.joe.homeexercise.repository.SellerRepository;

/**
 * @author Joe
 *
 */
@Service
public class ItemEligibilityService {
	
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private ProgramRepository programRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private PriceRepository priceRepository;
	
	public boolean isItemEligible(String sellerName,Integer categoryId,Double minPrice)
	{
		if(!isSellerEligible(sellerName))
			return false;
		if(!isCategoryEligible(categoryId))
			return false;
		if(!isItemPriceGreaterThanMinimumPrice(minPrice))
			return false;
		return true;
	}
	
	private boolean isSellerEligible(String sellerName)
	{
		ProgramEntity program = programRepository.findByProgramNameAndActiveInd("remote location shipping program","Y");
		if(null!=program)
		return sellerRepository.findBySellerNameAndProgramId(sellerName.toLowerCase(),program.programId)==null?false:true;
		return false;
	}
	
	private boolean isCategoryEligible(Integer categoryId)
	{
		
		return categoryRepository.findByCategoryId(categoryId)==null?false:true;
		
	}
	
	private boolean isItemPriceGreaterThanMinimumPrice(Double itemPrice)
	{
		
		return priceRepository.findByMinPriceLessThanEqual(itemPrice)==null?false:true;
		
	}

}
