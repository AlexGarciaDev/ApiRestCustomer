package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandarizeApiExceptionResponse> handlerException(Exception e){
		StandarizeApiExceptionResponse response = new StandarizeApiExceptionResponse(null,null, null, e.getMessage());
		return new ResponseEntity<StandarizeApiExceptionResponse>(response, HttpStatus.PARTIAL_CONTENT);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandarizeApiExceptionResponse> handlerException(DatabaseException e){
		StandarizeApiExceptionResponse response = new StandarizeApiExceptionResponse(e.getType(),e.getTitle(), e.getCode(), e.getMessage());
		return new ResponseEntity<StandarizeApiExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
}
