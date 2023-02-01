package com.cg.onlinevegetablestore.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlinevegetablestore.entity.Order;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.repository.OrderRepository;


@Service
public class OrderServiceImp implements IOrderService{
	
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public Order addOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public List<Order> listAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order getOrderById(Long orderId) throws ResourceNotFoundException {
		return orderRepo.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("order not found"));
	}

	@Override
	public Order updateOrder(Order order, Long orderId) throws ResourceNotFoundException {
		return null;
	}

	@Override
	public void deleteOrder(Long orderId) {
		orderRepo.deleteById(orderId);
		
	}
}