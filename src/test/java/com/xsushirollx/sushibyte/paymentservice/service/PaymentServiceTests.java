package com.xsushirollx.sushibyte.paymentservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.stripe.exception.StripeException;
import com.xsushirollx.sushibyte.paymentservice.dao.FoodDAO;
import com.xsushirollx.sushibyte.paymentservice.dto.FoodOrderDTO;
import com.xsushirollx.sushibyte.paymentservice.dto.OrderItemDTO;
import com.xsushirollx.sushibyte.paymentservice.model.Food;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PaymentServiceTests {

	@InjectMocks
	PaymentService pservice;
	
	@Mock
	FoodDAO mockFoodDAO;
	
	@BeforeEach
	public void setUp() {
		
	}
	
	@Test
	public void orderTotals() {
		when(mockFoodDAO.findById((long) 1)).thenReturn(Optional.of(new Food((long) 1, "ABC Soup", (double) 6.99, null, null, null)));
		when(mockFoodDAO.findById((long) 3)).thenReturn(Optional.of(new Food((long) 3, "Hot Potato Soup", (double) 8.99, null, null, null)));
		
		
		List<FoodOrderDTO> orders = new ArrayList<>();
		List<OrderItemDTO> items = new ArrayList<>();
		//actual is 6.99
		items.add(new OrderItemDTO((long) 1, 2, (float) 0.99, "ABC Soup",(long) 56));
		//actually is 8.99
		items.add(new OrderItemDTO((long) 3, 4, (float) 1.99, "Hot Potato Soup",(long) 56));
		
		orders.add(new FoodOrderDTO(null, null, 65, items));
		assertEquals(pservice.ordersTotal(orders), 49.94);
		
	}
	
	@Test
	public void getClientSecret() throws StripeException {
		when(mockFoodDAO.findById((long) 1)).thenReturn(Optional.of(new Food((long) 1, "ABC Soup", (double) 6.99, null, null, null)));
		when(mockFoodDAO.findById((long) 3)).thenReturn(Optional.of(new Food((long) 3, "Hot Potato Soup", (double) 8.99, null, null, null)));
		
		
		List<FoodOrderDTO> orders = new ArrayList<>();
		List<OrderItemDTO> items = new ArrayList<>();
		//actual is 5.99
		items.add(new OrderItemDTO((long) 1, 2, (float) 0.99, "ABC Soup",(long) 56));
		//actually is 11.99
		items.add(new OrderItemDTO((long) 3, 4, (float) 1.99, "Hot Potato Soup",(long) 56));
		
		orders.add(new FoodOrderDTO(null, null, 65, items));
		assert(pservice.getClientSecret(orders) != null);
		
	}
}
