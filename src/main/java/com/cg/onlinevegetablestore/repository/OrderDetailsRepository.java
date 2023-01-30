package com.cg.onlinevegetablestore.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinevegetablestore.entity.OrderDetails;


public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

}
