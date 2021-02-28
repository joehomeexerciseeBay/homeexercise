/**
 * 
 */
package com.joe.homeexercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.homeexercise.repository.CategoryRepository;
import com.joe.homeexercise.repository.PriceRepository;
import com.joe.homeexercise.repository.SellerRepository;
import com.joe.homeexercise.util.EligibilityEnum;

/**
 * @author Joe
 *
 */
@Service
public class ItemEligibilityService {
	
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private PriceRepository priceRepository;
	
	public List<EligibilityEnum> isItemEligible(String sellerName,Integer categoryId,Double minPrice)
	{
		List<EligibilityEnum> result = new ArrayList<>();
		if(!isSellerEligible(sellerName))
			result.add(EligibilityEnum.SELLER);
		if(!isCategoryEligible(categoryId))
			result.add(EligibilityEnum.CATEGORY);
		if(!isItemPriceGreaterThanMinimumPrice(minPrice))
			result.add(EligibilityEnum.PRICE);
		return result;
	}
	
	private boolean isSellerEligible(String sellerName)
	{
		return sellerRepository.findBySellerNameIgnoreCase(sellerName)==null?false:true;
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
