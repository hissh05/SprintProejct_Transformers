package com.cg.onlinevegetablestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;

import com.cg.onlinevegetablestore.entity.Vegetables;
@Repository //marks this interface as repository 
public interface VegetablesRepository extends JpaRepository<Vegetables, Long> {
	//select * from vegetable where vegetable_name = ?
		public Vegetables findByVegetablesName(String vegName);
		
		
		
		//list all vegetable which are less than vegprice
		//select * from vegetable where vegetable_price < ?
		public List<Vegetables> findByVegetablesPriceLessThan(float vegPrice);
		
		//list all vegetable which are less than vegprice
		//select * from vegetable where vegetable_price > ?
		public List<Vegetables> findByVegetablesPriceGreaterThan(float vegPrice);

	}