package com.murilo.teste.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RequestHandler {
	
	@ExceptionHandler(value = {RequestException.class})
	public ResponseEntity<Object> handleRequestException(RequestException e){
		
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		Exception exception = new Exception(e.getMessage(), e, HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
		
		return new ResponseEntity<>(exception,badRequest);
	}

}
