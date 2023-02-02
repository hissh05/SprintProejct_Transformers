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

import com.cg.onlinevegetablestore.entity.Vegetables;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.service.IAdminService;
import com.cg.onlinevegetablestore.service.ICustomerService;
import com.cg.onlinevegetablestore.service.IImagesService;
import com.cg.onlinevegetablestore.service.IOrderDetailsService;
import com.cg.onlinevegetablestore.service.IOrderService;
import com.cg.onlinevegetablestore.service.IVegitableService;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebMvcTest
public class VegetablesControllerTest {
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
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Vegetables vegetables;
	private Vegetables vegetables1;
	@BeforeEach
	public void init() {
		vegetables = new Vegetables(1L,"Brinjal",23,"23");
		vegetables1 = new Vegetables(2L,"Tomato",30,"50");
	
	}
	
	@Test
	public void testAddVegetables() throws Exception{
		when(vegitableService.addVegetables((Vegetables) any(Vegetables.class))).thenReturn(vegetables);
	}
	
	@Test
	public void testlistAllVegetables() {
		List<Vegetables> veggieList = new ArrayList<Vegetables>();
		veggieList.add(vegetables);
		veggieList.add(vegetables1);
		when(vegitableService.listAllVegetables()).thenReturn(veggieList);
	}
	
	@Test
	public void testgetVegetablesById() throws ResourceNotFoundException {	
		when(vegitableService.getVegetablesById(anyLong())).thenReturn(vegetables);
	}

}
