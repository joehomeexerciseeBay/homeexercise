package com.joe.homeexercise.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SellerProgramMappingId implements Serializable {
	@Column(name="SELLER_ID")
	private Integer sellerId;
	@Column(name="PROGRAM_ID")
	private Integer programId;

}
