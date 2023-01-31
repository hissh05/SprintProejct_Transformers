package com.cg.onlinevegetablestore.service;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlinevegetablestore.entity.OrderDetails;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;

public interface IOrderDetailsService {
	public OrderDetails orderDetails(Long orderId,OrderDetails orderDetails) throws ResourceNotFoundException;
	public List<OrderDetails> getAllOrderDetailsByOrderId(Long orderId);
    public List<OrderDetails> getAllOrderDetailsByDate(Date date);
}