package com.xsushirollx.sushibyte.paymentservice.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stripe.exception.StripeException;
import com.xsushirollx.sushibyte.paymentservice.dto.FoodOrderDTO;
import com.xsushirollx.sushibyte.paymentservice.service.PaymentService;


@Controller
public class PaymentController {
	
	Logger log = Logger.getLogger("PaymentController");
	@Autowired
	PaymentService pservice;
	
	@PreAuthorize("hasAnyAuthority('CUSTOMER', 'ADMINISTRATOR')")
	@PostMapping("/payment")
    ResponseEntity<?> addNewFoodMenuItem(@RequestBody List<FoodOrderDTO> orders) throws StripeException {
    	return new ResponseEntity<>(pservice.getClientSecret(orders), HttpStatus.CREATED);
    }

}
