package com.cg.onlinevegetablestore.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.onlinevegetablestore.entity.Order;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.service.IOrderService;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest
public class OrderControllerTest {
	 
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IOrderService orderService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Order order;
	private Order order1;
	Date d = new Date();
	@BeforeEach
	public void init() {
		order = new Order(4567L, 789L, 45, d, "uk");
		order1 = new Order(789L, 345L, 89, d, "us");
	}
	
	@Test
	public void testAddOrder() throws Exception{
		when(orderService.addOrder((Order) any(Order.class))).thenReturn(order);
	}
	
	@Test
	public void testlistAllOrders() {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(order);
		orderList.add(order1);
		when(orderService.listAllOrders()).thenReturn(orderList);
	}
	
	@Test
	public void testgetOrderById() throws ResourceNotFoundException {	
		when(orderService.getOrderById(anyLong())).thenReturn(order);
	}



}
