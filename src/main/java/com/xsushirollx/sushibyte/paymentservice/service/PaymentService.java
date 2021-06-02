package com.xsushirollx.sushibyte.paymentservice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.xsushirollx.sushibyte.paymentservice.dao.FoodDAO;
import com.xsushirollx.sushibyte.paymentservice.dto.FoodOrderDTO;
import com.xsushirollx.sushibyte.paymentservice.dto.OrderItemDTO;

@Service
public class PaymentService {
	
	@Autowired
	FoodDAO fdao;
	
	private final String API_KEY = "sk_test_51Iwe6JI3Xcs3HqD58EIktgAoDmcfazeFLBufgPihXrAcbclMf9E1CzBM1OWll7Xrf0wIDyoaGUoQkFMXyOt99L5h004AmBompb";

	public Double ordersTotal(List<FoodOrderDTO> orders) {
		Double orderTotal = 0.0;
		for (FoodOrderDTO order : orders) {
			for (OrderItemDTO o : order.getOrderItems()) {
				orderTotal += fdao.findById(o.getFoodId()).get().getCost() * o.getQuantity();
			}
		}
		return orderTotal;
	}
	
	//should each order be its own payment intent or it be one?
	//for now they are one 
	//add customer field
	public String getClientSecret(List<FoodOrderDTO> orders) throws StripeException, NumberFormatException {
		Stripe.apiKey = API_KEY;

		PaymentIntentCreateParams params =
				  PaymentIntentCreateParams.builder()
				    .setCurrency("usd")
				    .setAmount((long) (ordersTotal(orders)*100))
				    // Verify your integration in this guide by including this parameter
				    .putMetadata("integration_check", "accept_a_payment")
				    .build();

		PaymentIntent paymentIntent = PaymentIntent.create(params);
		return paymentIntent.getClientSecret();
	}

}
