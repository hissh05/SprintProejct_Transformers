package com.cg.onlinevegetablestore.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlinevegetablestore.repository.OrderDetailsRepository;
import com.cg.onlinevegetablestore.repository.OrderRepository;
import com.cg.onlinevegetablestore.entity.OrderDetails;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;

@Service
public class OrderDetailsServiceImp implements IOrderDetailsService  {
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public OrderDetails orderDetails(Long orderId, OrderDetails orderDetails) throws ResourceNotFoundException {
		return orderRepository.findById(orderId).map(order -> {
			orderDetails.setOrder(order);
			return orderDetailsRepository.save(orderDetails);
		}).orElseThrow(() -> new ResourceNotFoundException("order not found"));
	}

	@Override
	public List<OrderDetails> getAllOrderDetailsByOrderId(Long orderId) {
		return orderDetailsRepository.findByOrder_OrderId(orderId);
	}
	@Override
	public ResponseEntity<?> deleteImage(Long orderId) throws ResourceNotFoundException {
		List<OrderDetails> orderDetails = orderDetailsRepository.findByOrder_OrderId(orderId);
		for (OrderDetails oD : orderDetails){
			orderDetailsRepository.delete(oD);
		}
		return ResponseEntity.ok().build();
	}

}