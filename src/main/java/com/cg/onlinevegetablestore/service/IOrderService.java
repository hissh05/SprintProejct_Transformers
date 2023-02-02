package com.cg.onlinevegetablestore.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.cg.onlinevegetablestore.entity.Order;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;

public interface IOrderService {
	public Order addOrder(Order order);
	public List<Order> listAllOrders();
	public Order getOrderById(Long orderId)  throws ResourceNotFoundException;
	public Order updateOrder(Order order,Long orderId) throws ResourceNotFoundException;
	public void deleteOrder(Long orderId);


}