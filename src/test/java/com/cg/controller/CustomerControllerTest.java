package com.cg.onlinevegetablestore.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.onlinevegetablestore.entity.Customer;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.service.IAdminService;
import com.cg.onlinevegetablestore.service.ICustomerService;
import com.cg.onlinevegetablestore.service.IImagesService;
import com.cg.onlinevegetablestore.service.IOrderDetailsService;
import com.cg.onlinevegetablestore.service.IOrderService;
import com.cg.onlinevegetablestore.service.IVegitableService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class CustomerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
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
//	
//	@MockBean
//	private ICategoryService categoryService;
//	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Customer customer;
	private Customer customer1;
	@BeforeEach
	public void init() {
		customer = new Customer("Kunal", "k@gmail.com", "k123", "987");
		customer1 = new Customer("Omkar", "o@gmail.com", "o123", "234");
	
	}
	
	@Test
	public void testcreateCustomer() throws Exception{
		when(customerService.createCustomer((Customer) any(Customer.class))).thenReturn(customer);
	}
	
	@Test
	public void testgetCustomerList() {
		List<Customer> custList = new ArrayList<Customer>();
		custList.add(customer);
		custList.add(customer1);
		when(customerService.getCustomerList()).thenReturn(custList);
	}
	
//	@Test
//	public void testgetCustomerById() throws ResourceNotFoundException {	
//		when(customerService.getCustomerById(anyLong())).thenReturn(customer);
//		
//		
		
}
