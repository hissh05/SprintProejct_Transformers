package com.cg.onlinevegetablestore.controller;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.onlinevegetablestore.entity.OrderDetails;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.service.IOrderDetailsService;

public class OrderDetailsController {
private IOrderDetailsService orderDetailsService;
	
	@PostMapping("/orders/{orderId}/orderdetails")
	public OrderDetails orderDetails(@PathVariable(value="orderId") String orderId,
			@Valid @RequestBody OrderDetails orderDetails) throws ResourceNotFoundException
	{
		return orderDetailsService.orderDetails(orderId, orderDetails);
	}
	
	//get all the order details by corresponding orderId
	@GetMapping("/orders/{orderId}/orderdetails")
	public List<OrderDetails> getAllOrderDetailsByOrderId(@PathVariable(value="orderId") String orderId)
	{
		return orderDetailsService.getAllOrderDetailsByOrderId(orderId);
	}
	
	//delete order details by corresponding orderId
	@GetMapping("/orders/{date}/orderdetails")
	public List<OrderDetails> getAllOrderDetailsByDate(@PathVariable(value="orderId") Date date){
		return orderDetailsService.getAllOrderDetailsByDate(date);
	}
}





