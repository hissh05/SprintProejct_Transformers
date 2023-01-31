package com.cg.onlinevegetablestore.service;

import java.util.List;

import com.cg.onlinevegetablestore.entity.Vegetables;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;

public interface IVegitableService {
	public Vegetables addVegetables(Vegetables veggie);
	public List<Vegetables> listAllVegetables();
	public Vegetables getVegetablesById(Long vegId)  throws ResourceNotFoundException;
	public Vegetables updateVegetables(Vegetables veggie,Long vegId) throws ResourceNotFoundException;
	public void deleteVegetables(Long vegId);
	public Vegetables findByVegetablesName(String vegName) ;
	public List<Vegetables> findByVegetablesQuantity(String vegQuantity) ;
	public List<Vegetables> findByVegetablesPriceLessThan(float vegPrice);
	public List<Vegetables> findByVegetablesPriceGreaterThan(float vegPrice);

}
