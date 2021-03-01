package com.joe.homeexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joe.homeexercise.HomeExerciseTrace;
import com.joe.homeexercise.model.PriceEntity;

public interface PriceRepository extends JpaRepository<PriceEntity, Double> {
	@HomeExerciseTrace
	PriceEntity findByMinPriceLessThanEqual(Double price);
}
