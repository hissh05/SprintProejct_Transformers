package com.cg.onlinevegetablestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlinevegetablestore.repository.CustomerRepository;
import com.cg.onlinevegetablestore.entity.Customer;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;

@Service
public class CustomerServiceImp implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getCustomerList() {
		return customerRepository.findAll();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public ResponseEntity<Customer> getCustomerById(Long userId) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(userId)
		          .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + userId));
		        return ResponseEntity.ok().body(customer);
	}

	@Override
	public ResponseEntity<Customer> getCustomerByUsernameAndEmail(String userName, String Email)
			throws ResourceNotFoundException {
		 Customer customer = customerRepository.findByUserNameAndEmail(userName, Email)
		          .orElseThrow(() -> new ResourceNotFoundException("Customer not found "));
		        return ResponseEntity.ok().body(customer);
	}

	@Override
	public ResponseEntity<Customer> updateCustomer(Long userId, Customer customerDetails)
			throws ResourceNotFoundException {
		  Customer customer = customerRepository.findById(userId)
			        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + userId));

			        customer.setEmail(customerDetails.getEmail());
			        customer.setUserName(customerDetails.getUserName());
			        customer.setPassword(customerDetails.getPassword());
			        customer.setAddress(customerDetails.getAddress());
			        customer.setMobileNo(customerDetails.getmobileNo());
			        
			        final Customer updatedCustomer = customerRepository.save(customer);
			        return ResponseEntity.ok(updatedCustomer);
			        
			        
	}
	@Override
	public void deleteCustomer(Long userId) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(userId);
		
	}

	

}