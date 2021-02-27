package com.joe.homeexercise.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name="SELLER_ID")
	private Integer sellerId;
	
	@Column(name="USER_NAME")
	private String sellerName;
	
	@Column(name="PROGRAM_ID")
	private Integer programId; 

	 

}
