/**
 * 
 */
package com.joe.homeexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joe.homeexercise.HomeExerciseTrace;
import com.joe.homeexercise.model.CategoryEntity;

/**
 * @author Joe
 *
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
	@HomeExerciseTrace
	CategoryEntity findByCategoryId(Integer categoryId);
	@HomeExerciseTrace
	CategoryEntity findByCategoryNameIgnoreCase(String categoryName);
}
