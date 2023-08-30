package com.app.exception;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(BadCredentialsException exc)
	{
		System.out.println("In methodargument exception "+exc);
//		List<FieldError> list = exc.get;
////		Map<String, String> map = list.stream().collect();
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(resourceNotFoundException.class)
	public ResponseEntity<String> handlePropertyPolicyException(resourceNotFoundException p){
		return new ResponseEntity<String>(p.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
