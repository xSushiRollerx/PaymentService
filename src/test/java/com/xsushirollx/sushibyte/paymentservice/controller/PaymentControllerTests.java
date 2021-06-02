package com.xsushirollx.sushibyte.paymentservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xsushirollx.sushibyte.paymentservice.dto.FoodOrderDTO;
import com.xsushirollx.sushibyte.paymentservice.security.JWTUtil;
import com.xsushirollx.sushibyte.paymentservice.service.PaymentService;

import antlr.collections.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

@AutoConfigureMockMvc
@SpringBootTest
public class PaymentControllerTests {
	
	@Autowired
	MockMvc mockMvc;

	@MockBean
	PaymentService pservice;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	JWTUtil util;
	
	@BeforeEach
	public void setUp() {
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void postClientSecret200() throws JsonProcessingException, Exception {
		String token  = "Bearer " + util.generateToken("1");
		
		when(pservice.getClientSecret((java.util.List<FoodOrderDTO>) Mockito.any(List.class))).thenReturn("client_secret");
		
		mockMvc.perform(post("/payment").header("Authorization", token).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new ArrayList<FoodOrderDTO>())))
				.andExpect(status().isCreated());
		
	}
	
}
