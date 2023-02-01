package com.cg.onlinevegetablestore.controller;

import static org.hamcrest.CoreMatchers.any;
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

import com.cg.onlinevegetablestore.entity.Admin;
import com.cg.onlinevegetablestore.entity.Order;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.service.IAdminService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class AdminControllerTest {
	@Autowired
	private MockMvc mockMvc;
		
		@MockBean
		private IAdminService adminService;
		
		@Autowired
		private ObjectMapper objectMapper;
		
		private Admin admin;
		private Admin admin1;
		
		@BeforeEach
		public void init() {
			admin = new Admin("Viraj","Pawar","viraj@gmail.com","virpp","123");
			admin1 = new Admin("Pranav","Bakre","pranav@gmail.com","pbkre","23123");
		}
		
		@Test
		public void testAddAdmin() throws Exception{
			when(adminService.addAdmin((Admin) any(Order.class))).thenReturn(admin);
		}
		
		@Test
		public void testgetAllAdmins() {
			List<Admin> adminList = new ArrayList<Admin>();
			adminList.add(admin);
			adminList.add(admin1);
			when(adminService.getAllAdmins()).thenReturn(adminList);
		}
		
		@Test
		public void testgetAdminById1() throws ResourceNotFoundException {	
			when(adminService.getAdminById(anyLong())).thenReturn(admin);
		}


}
