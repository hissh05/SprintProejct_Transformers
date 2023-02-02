package com.cg.onlinevegetablestore.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.cg.onlinevegetablestore.repository.OrderDetailsRepository;
import com.cg.onlinevegetablestore.repository.OrderRepository;
import com.cg.onlinevegetablestore.entity.OrderDetails;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;

public class OrderDetailsServiceImp implements IOrderDetailsService  {
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public OrderDetails orderDetails(String orderId, OrderDetails orderDetails) throws ResourceNotFoundException {
		return orderRepository.findById(orderId).map(order -> {
			orderDetails.setOrder(order);
			return orderDetailsRepository.save(orderDetails);
		}).orElseThrow(() -> new ResourceNotFoundException("order not found"));
	}

	@Override
	public List<OrderDetails> getAllOrderDetailsByOrderId(String orderId) {
		return orderDetailsRepository.findByOrderDetailsID(orderId);
	}

	@Override
	public List<OrderDetails> getAllOrderDetailsByDate(Date date){
		return orderDetailsRepository.findByDate(date);
	}
}