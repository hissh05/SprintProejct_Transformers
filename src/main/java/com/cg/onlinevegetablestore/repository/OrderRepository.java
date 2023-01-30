package com.cg.onlinevegetablestore.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinevegetablestore.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
