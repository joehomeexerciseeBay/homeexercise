/**
 * 
 */
package com.joe.homeexercise.service;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.joe.homeexercise.model.CategoryEntity;
import com.joe.homeexercise.model.PriceEntity;
import com.joe.homeexercise.model.SellerEntity;
import com.joe.homeexercise.repository.CategoryRepository;
import com.joe.homeexercise.repository.PriceRepository;
import com.joe.homeexercise.repository.SellerRepository;

/**
 * @author Joe
 *
 */
@SpringBootTest
public class ItemEligibilityServiceTest {
	@Mock
	SellerRepository sellerRepo;
	@Mock
	CategoryRepository categoryRepo;
	@Mock
	PriceRepository priceRepo;
	
	@InjectMocks
	ItemEligibilityService service;
	
	@Test
	public void isItemEligible()
	{
		Mockito.when(sellerRepo.findBySellerNameIgnoreCase(Mockito.anyString())).thenReturn(new SellerEntity("someseller"));
		Mockito.when(categoryRepo.findByCategoryNameIgnoreCase(Mockito.anyString())).thenReturn(new CategoryEntity(1,"somecategory"));
		Mockito.when(priceRepo.findByMinPriceLessThanEqual(Mockito.anyDouble())).thenReturn(new PriceEntity(10.99));
		service.isItemEligible("someseller", 1, 10.99);
	}

}
