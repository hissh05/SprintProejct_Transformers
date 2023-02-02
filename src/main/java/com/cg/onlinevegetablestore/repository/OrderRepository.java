package com.cg.onlinevegetablestore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinevegetablestore.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	Optional<Order> findByUsernameAndEmail(String userName, String Email);

	Optional<Order> findById(String orderId);

}


