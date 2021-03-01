/**
 * 
 */
package com.joe.homeexercise.Repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.joe.homeexercise.repository.SellerRepository;

/**
 * @author Joe
 *
 */
@SpringBootTest
public class SellerRepositoryTest {
	@Mock
	SellerRepository repo;
	
	@Test
	public void emptySeller()
	{
		repo.findBySellerNameIgnoreCase("");
	}

}
