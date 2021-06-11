package com.xsushirollx.sushibyte.paymentservice.controller;

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
import com.xsushirollx.sushibyte.paymentservice.dao.UserDAO;
import com.xsushirollx.sushibyte.paymentservice.dto.FoodOrderDTO;
import com.xsushirollx.sushibyte.paymentservice.model.User;
import com.xsushirollx.sushibyte.paymentservice.security.JWTUtil;
import com.xsushirollx.sushibyte.paymentservice.service.PaymentService;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest
public class PaymentControllerTests {
	
	@Autowired
	MockMvc mockMvc;

	@MockBean
	PaymentService pservice;
	
	@MockBean
	UserDAO udao;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	JWTUtil util;
	

	
	@SuppressWarnings("unchecked")
	@Test
	public void postClientSecret201() throws JsonProcessingException, Exception {
		String token  = "Bearer " + util.generateToken("96");
		
		when(pservice.getClientSecret((List<FoodOrderDTO>) Mockito.any(List.class))).thenReturn("client_secret");
		when(udao.findById(Mockito.anyInt())).thenReturn(Optional.of(new User(96, 1)));
		
		mockMvc.perform(post("/payment").header("Authorization", token).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new ArrayList<FoodOrderDTO>())))
				.andExpect(status().isCreated());
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void postClientSecret500() throws JsonProcessingException, Exception {
		String token  = "Bearer " + util.generateToken("1");
		
		when(pservice.getClientSecret( (List<FoodOrderDTO>) Mockito.any(List.class))).thenThrow(new NumberFormatException());
		when(udao.findById(Mockito.anyInt())).thenReturn(Optional.of(new User(96, 1)));
		
		
		mockMvc.perform(post("/payment").header("Authorization", token).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new ArrayList<FoodOrderDTO>())))
				.andExpect(status().isInternalServerError());
		
	}
	
}
