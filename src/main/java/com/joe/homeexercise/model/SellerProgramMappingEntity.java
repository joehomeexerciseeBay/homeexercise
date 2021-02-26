package com.joe.homeexercise.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SellerProgramMappingEntity implements Serializable {
	@EmbeddedId
	private SellerProgramMappingId mappingId;

	@Column(name="COMMENTS")
	public String comments;

}
