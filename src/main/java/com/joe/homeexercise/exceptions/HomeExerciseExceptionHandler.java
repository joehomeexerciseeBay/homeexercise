/**
 * 
 */
package com.joe.homeexercise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * Customized ResponseEntityExceptionHandler which will handle all application exceptions generated
 * by HomeExercise service during request handling
 * 
 * @author joe.s.alphonse@gmail.com
 *
 */
@Slf4j
@ControllerAdvice
public class HomeExerciseExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * Handle any errors not caught by other specific handlers. This will be reported as 
	 * HTTP 500 INTERNAL_SERVER_ERROR
	 * 
	 * @param ex Exception
	 * @param request HTTP request
	 * @return ResponseEntity containing an appropriate HomeExerciseErrorResposne
	 */
	public final ResponseEntity<HomeExerciseErrorResponse> handleAllExceptions(Exception ex, WebRequest request)
	{
		log.error("request handling encountered error processing request for: {}", request==null?"no request present!" : request.getDescription(true),ex);
		HomeExerciseErrorResponse errorDetails = new HomeExerciseErrorResponse(ex.getMessage(), 
				request.getDescription(false), ErrorIDs.SERVER_ERROR);
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Handle unchecked HomeExercise error. 
	 * 
	 * @param ex Exception
	 * @param request HTTP request
	 * @return ResponseEntity containing an appropriate HomeExerciseErrorResposne
	 */
	@ExceptionHandler(HomeExerciseApplicationError.class)
	public final ResponseEntity<HomeExerciseErrorResponse> handleAllExceptions(HomeExerciseApplicationError ex, WebRequest request)
	{
		log.error("request handling encountered error processing request for: {}", request==null?"no request present!" : request.getDescription(true),ex);
		String details=(ex.getDetails()==null || ex.getDetails().isEmpty())?request.getDescription(false):ex.getDetails();
		HomeExerciseErrorResponse errorDetails = new HomeExerciseErrorResponse(ex.getMessage(), 
				details,ex.getErrorCode());
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Handle general HomeExercise application errors.  
	 * 
	 * @param ex Exception
	 * @param request HTTP request
	 * @return ResponseEntity containing an appropriate HomeExerciseErrorResposne
	 */
	@ExceptionHandler(HomeExerciseApplicationException.class)
	public final ResponseEntity<HomeExerciseErrorResponse> handleAllExceptions(HomeExerciseApplicationException ex, WebRequest request)
	{
		String details=(ex.getDetails()==null || ex.getDetails().isEmpty())?request.getDescription(false):ex.getDetails();
		HttpStatus status;
		switch(ex.getErrorCode()) {
		case SERVER_ERROR:
			status=HttpStatus.INTERNAL_SERVER_ERROR;
			log.error("HomeExercise application error during processing of request for: {}",request.getDescription(true),ex);
			break;
		case BAD_INPUTS:
			status=HttpStatus.BAD_REQUEST;
			log.debug("User input bad parameters: {}",request.getParameterMap(),ex);
			break;
		case NO_PERMISSION:
			status = HttpStatus.FORBIDDEN;
			log.info("User does not have permission {}", request.getDescription(true),ex);
			break;
		case INVALID_RULES:
			status = HttpStatus.BAD_REQUEST;
			log.debug("Invalid  user privileges {}", request.getDescription(true),ex);
			break;
		case NO_DATA_FOUND:
			status=HttpStatus.BAD_REQUEST;
			log.info("No data was found: {}", request.getDescription(true),ex);
			break;
		default:
			status=HttpStatus.INTERNAL_SERVER_ERROR;
			log.error("HomeExercise application error during processing of request for: {}",request.getDescription(true),ex);
			
			
		}
		HomeExerciseErrorResponse errorDetails = new HomeExerciseErrorResponse(ex.getMessage(), 
				details, ex.getErrorCode());
		return new ResponseEntity<>(errorDetails,status);
	}

	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public final ResponseEntity<HomeExerciseErrorResponse> handleAccessDeniedExceptions(Exception ex)
	{
		HomeExerciseErrorResponse errorDetails = new HomeExerciseErrorResponse("Access to the resource is forbidden", ex.getMessage(),ErrorIDs.NO_PERMISSION);
		return new ResponseEntity<>(errorDetails,HttpStatus.FORBIDDEN);
	}
}
