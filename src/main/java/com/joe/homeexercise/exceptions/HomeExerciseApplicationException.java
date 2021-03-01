/**
 * 
 */
package com.joe.homeexercise.exceptions;

import lombok.Getter;

/**
 * @author Joe
 *
 */
public class HomeExerciseApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	private ErrorIDs errorCode = null;
	
	@Getter
	private String details = "";
	
	public HomeExerciseApplicationException(ErrorIDs errorCode, String errorMessage, String details)
	{
		super(errorMessage);
		this.errorCode=errorCode;
		this.details=details;
	}
	
	public HomeExerciseApplicationException(ErrorIDs errorCode, String errorMessage)
	{
		this(errorCode,errorMessage,null);
	}

}
