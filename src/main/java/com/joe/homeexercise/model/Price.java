/**
 * 
 */
package com.joe.homeexercise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Joe
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price {
	private Double minimumPrice;

}
