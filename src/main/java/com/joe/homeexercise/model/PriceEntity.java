/**
 * 
 */
package com.joe.homeexercise.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Joe
 *
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="Minimum_price")
public class PriceEntity implements Serializable{
	@Id
	@Column(name="Price")
	private Double minPrice;

}
