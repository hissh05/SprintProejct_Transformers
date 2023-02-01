package com.cg.onlinevegetablestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinevegetablestore.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
}


