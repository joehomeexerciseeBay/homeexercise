/**
 * 
 */
package com.joe.homeexercise.exceptions;

import lombok.Getter;

/**
 * Data object used to report errors to callers making REST request to the service.
 * This will be serailaized to JSON and returned in the body of an HTTP error response.
 * 
 * @author joe.s.alphonse@gmail.com
 *
 */
@Getter
public class HomeExerciseErrorResponse {
	private ErrorIDs errorCode;// General classification of error for client-side reporting
	private String message;// Message describing error for use by developers
	private String details;// any relevant error details, use to help particularize specific error
	
	/**
	 * Construct a fully populated error response object.
	 * @param message
	 * @param details
	 * @param errorCode Error code from ErrorIDs enum
	 */
	public HomeExerciseErrorResponse(String message,String details, ErrorIDs errorCode)
	{
		this.errorCode=errorCode;
		this.message=message;
		this.details=details;
	}

}
