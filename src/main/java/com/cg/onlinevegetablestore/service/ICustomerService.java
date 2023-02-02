package com.cg.onlinevegetablestore.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlinevegetablestore.entity.Customer;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;

public interface ICustomerService {
	public List<Customer> getCustomerList();
	public Customer createCustomer(Customer customer);
    public ResponseEntity<Customer> getCustomerById(Long userId) throws ResourceNotFoundException;
	public ResponseEntity<Customer> getCustomerByUsernameAndEmail(String userName,
			String Email) throws ResourceNotFoundException;
    public ResponseEntity<Customer> updateCustomer(Long userId,
           Customer customerDetails) throws ResourceNotFoundException;
	public void deleteCustomer(Long userId);

}