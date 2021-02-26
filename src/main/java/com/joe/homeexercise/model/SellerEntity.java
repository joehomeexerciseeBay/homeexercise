package com.joe.homeexercise.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name="SELLER_ID")
	public Integer sellerId;
	
	@Column(name="USER_NAME")
	public String sellerName;
	
	/*
	 * @OneToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumns({
	 * 
	 * @JoinColumn(name = "SELLER_ID", referencedColumnName = "SELLER_ID",
	 * insertable = false, updatable = false),
	 * 
	 * @JoinColumn(name = "PROGRAM_ID", referencedColumnName = "PROGRAM_ID",
	 * insertable = false, updatable = false), })
	 * 
	 * @JsonIgnore private SellerProgramMappingEntity mappingId;
	 */

}
