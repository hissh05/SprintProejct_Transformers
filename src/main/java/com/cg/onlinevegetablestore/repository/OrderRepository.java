package com.cg.onlinevegetablestore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinevegetablestore.entity.Order;
import com.cg.onlinevegetablestore.entity.Vegetables;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
//	Optional<Order> findByUsernameAndEmail(String userName, String Email);

//	Optional<Order> findById(String orderId);
//	public Vegetables findByVegetableName(String vegName);
//	
//	//list all vegetables under a category
//	//select * from vegetable where vegetable_category = ?
//	public List<Vegetables> findByVegetableCategory(String vegCategory);
//	
//	//list all vegetable which are less than vegprice
//	//select * from vegetable where vegetable_price < ?
//	public List<Vegetables> findByVegetablePriceLessThan(float vegPrice);
//	
//	//list all vegetable which are less than vegprice
//	//select * from vegetable where vegetable_price > ?
//	public List<Vegetables> findByVegetablePriceGreaterThan(float vegPrice);
}


