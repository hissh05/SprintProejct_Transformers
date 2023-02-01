package com.cg.onlinevegetablestore.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinevegetablestore.entity.OrderDetails;
import com.cg.onlinevegetablestore.repository.OrderDetailsRepository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>{
	//select * from Orderdetails where order_id = ?
		public List<OrderDetails> findByOrder_OrderId(Long orderId);
		//select * from Orderdetails where date = ?
		public List<OrderDetails> findByDate(Date bydate);
}