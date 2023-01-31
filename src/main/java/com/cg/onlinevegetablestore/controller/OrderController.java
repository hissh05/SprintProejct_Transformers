package com.cg.onlinevegetablestore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinevegetablestore.entity.Order;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.service.IOrderService;


@RestController 
@RequestMapping("/api/v1")
	public class OrderController {
		
	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/addorder")
	public Order addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
		
	}
	
	@GetMapping("/listallorders")
	public List<Order> listAllOrders(){
		return orderService.listAllOrders();
	}
	
	@GetMapping("/getorder/{orderid}")
	public Order getOrderById(@PathVariable("orderid")Long orderId)  throws ResourceNotFoundException{
		return orderService.getOrderById(orderId);
	}
	
	@PutMapping("/updateorder/{orderid}")
	public Order updateOrder(@RequestBody Order order,@PathVariable("orderid")Long orderId) 
			throws ResourceNotFoundException{
		return orderService.updateOrder(order, orderId);
	}
	
	@DeleteMapping("/deleteorder/{orderid}")
	public void deleteOrder(@PathVariable("orderid")Long orderId) {
		orderService.deleteOrder(orderId);
	}

}
