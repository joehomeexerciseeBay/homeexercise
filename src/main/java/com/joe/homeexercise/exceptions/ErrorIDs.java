/**
 * 
 */
package com.joe.homeexercise.exceptions;

import lombok.Getter;

/**
 * @author Joe
 *
 */
public enum ErrorIDs {
	BAD_INPUTS,INVALID_RULES,SERVER_ERROR,NO_PERMISSION,NO_DATA_FOUND;
	
	@Getter
	private String message;
	

	private ErrorIDs(String message) {
		this.message=message;
	}


	ErrorIDs() {
		// TODO Auto-generated constructor stub
	}
}
