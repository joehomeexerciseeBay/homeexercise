package com.joe.homeexercise.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="Seller")
public class SellerEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SELLER_ID")
	private Integer sellerId;
	
	@Column(name="USER_NAME")
	private String sellerName;
	
	@Column(name="PROGRAM_ID")
	private Integer programId; 

	 public SellerEntity(String sellerName,Integer programId)
	 {
		 this.sellerName=sellerName;
		 this.programId=programId;
	 }

}
