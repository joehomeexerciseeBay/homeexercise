/**
 * 
 */
package com.joe.homeexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joe.homeexercise.model.CategoryEntity;

/**
 * @author Joe
 *
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
	
	CategoryEntity findByCategoryId(Integer categoryId);
	CategoryEntity findByCategoryNameIgnoreCase(String categoryName);
}
