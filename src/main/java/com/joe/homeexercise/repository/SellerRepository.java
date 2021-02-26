/**
 * 
 */
package com.joe.homeexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joe.homeexercise.model.SellerEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Joe
 *
 */
@Slf4j
@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Integer>{
	SellerEntity findBySellerName(String name);

}
