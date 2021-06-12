package com.xsushirollx.sushibyte.paymentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentControllerAdvice {
	
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		return new ResponseEntity<>("Status 500: Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
