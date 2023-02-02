package com.cg.onlinevegetablestore.controller;

import static org.mockito.Mockito.when;
import java.text.SimpleDateFormat;
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
import com.cg.onlinevegetablestore.entity.OrderDetails;
import com.cg.onlinevegetablestore.service.IAdminService;
import com.cg.onlinevegetablestore.service.ICustomerService;
import com.cg.onlinevegetablestore.service.IImagesService;
import com.cg.onlinevegetablestore.service.IOrderDetailsService;
import com.cg.onlinevegetablestore.service.IOrderService;
import com.cg.onlinevegetablestore.service.IVegitableService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest 
class OrderDetailsControllerTest {
	
	@Autowired 
	MockMvc mockMvc;
	@MockBean
	private IAdminService adminService;
	
	@MockBean
	private ICustomerService customerService;
	
	@MockBean
	private IVegitableService vegitableService;
	
	@MockBean
	private IImagesService imageService;
	
	@MockBean
	private IOrderService orderService;
	
	@MockBean
	private IOrderDetailsService orderDetailsService;
	Date date = new Date();
	@Autowired
	ObjectMapper objectMapper;
	private OrderDetails orderdetails;
	private OrderDetails orderdetails1;
	private Order order = new Order(1L,2L, 23, date,"Pune");
	
	@BeforeEach
	void init() {
		
		orderdetails = new OrderDetails(1L,"Placed",120.0,date,"chn",order);
		orderdetails1 = new OrderDetails(12L,"Deliverd",122.02,date,"pbkre",order);
		}
	
	@Test
	void testgetAllOrderDetailsByOrderId() throws Exception{
		List<OrderDetails> as = new ArrayList<>();
		as.add(orderdetails);
		when(orderDetailsService.getAllOrderDetailsByOrderId(order.getOrderId())).thenReturn(as);
	}
	@Test
	void testgetAllOrderDetailsByOrderId1() throws Exception{
		List<OrderDetails> as = new ArrayList<>();
		as.add(orderdetails1);
		when(orderDetailsService.getAllOrderDetailsByOrderId(order.getOrderId())).thenReturn(as);
	}
}
