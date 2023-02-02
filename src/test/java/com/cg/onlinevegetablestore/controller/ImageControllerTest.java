package com.cg.onlinevegetablestore.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.cg.onlinevegetablestore.service.IImagesService;
import com.cg.onlinevegetablestore.service.IOrderDetailsService;
import com.cg.onlinevegetablestore.service.IOrderService;
import com.cg.onlinevegetablestore.service.IVegitableService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.onlinevegetablestore.entity.Admin;
import com.cg.onlinevegetablestore.entity.Image;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.service.IAdminService;
import com.cg.onlinevegetablestore.service.ICustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class ImageControllerTest {

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
	
	private Image image;
	private Image image1;
	byte[] a = new byte[5];
	@BeforeEach
	public void init() {
		image = new Image("Tomato.png","veg",a);
		image1 = new Image("Potato.png","veg",a);
	}
	
	@Test
	public void testgetAllImages() {
		List<Image> imageList = new ArrayList<Image>();
		imageList.add(image);
		imageList.add(image1);
		when(imageService.getAllImages()).thenReturn(imageList);
	}
	
	@Test
	public void testgetImageById1() throws ResourceNotFoundException {	
		when(imageService.getImageByVegetablesId(anyLong())).thenReturn(image);
	}
}