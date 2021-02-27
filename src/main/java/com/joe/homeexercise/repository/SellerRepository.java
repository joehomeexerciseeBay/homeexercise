/**
 * 
 */
package com.joe.homeexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joe.homeexercise.model.SellerEntity;

/**
 * @author Joe
 *
 */

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Integer>{
	SellerEntity findBySellerName(String name);
	SellerEntity findBySellerNameAndProgramId(String name,int programId);

}
