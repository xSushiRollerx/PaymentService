package com.xsushirollx.sushibyte.paymentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xsushirollx.sushibyte.paymentservice.dto.FoodOrderDTO;
import com.xsushirollx.sushibyte.paymentservice.service.PaymentService;


@Controller
public class PaymentController {
	
	
	@Autowired
	PaymentService pservice;
	
//	@PreAuthorize("hasAnyAuthority('CUSTOMER', 'ADMINISTRATOR')")
	@PostMapping("/payment")
    ResponseEntity<?> addNewFoodMenuItem(@RequestBody List<FoodOrderDTO> orders) {
    	try {
			return new ResponseEntity<>(pservice.getClientSecret(orders), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
