package com.cg.onlinevegetablestore.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.onlinevegetablestore.entity.Vegetables;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.repository.VegetablesRepository;

@Service
public class VegetablesServiceImpl implements IVegitableService{
	@Autowired
	private VegetablesRepository vegetablesRepo;

	@Override
	public Vegetables addVegetables(Vegetables veggie) {
		return vegetablesRepo.save(veggie);
	}

	@Override
	public List<Vegetables> listAllVegetables() {
		return vegetablesRepo.findAll();
	}

	@Override
	public Vegetables getVegetablesById(Long vegId) throws ResourceNotFoundException {
		return vegetablesRepo.findById(vegId)
				.orElseThrow(() -> new ResourceNotFoundException("Vegetable Not found"));
	}

	@Override
	public Vegetables updateVegetables(Vegetables veggie, Long vegId) throws ResourceNotFoundException {
		Vegetables existingVegetables = vegetablesRepo.findById(vegId)
													.orElseThrow(() -> new ResourceNotFoundException("Vegetable Not found"));
	
		existingVegetables.setVegetablesName(veggie.getVegetablesName());
		existingVegetables.setVegetablesPrice(veggie.getVegetablesPrice());
		vegetablesRepo.save(existingVegetables);
		return existingVegetables;
	}

	@Override
	public void deleteVegetables(Long vegId)  {
		vegetablesRepo.deleteById(vegId);		
	}

	@Override
	public Vegetables findByVegetablesName(String vegName) {
		return vegetablesRepo.findByVegetablesName(vegName);
	}


	@Override
	public List<Vegetables> findByVegetablesPriceLessThan(float vegPrice) {
		return vegetablesRepo.findByVegetablesPriceLessThan(vegPrice);
	}

	@Override
	public List<Vegetables> findByVegetablesPriceGreaterThan(float vegPrice) {
		return vegetablesRepo.findByVegetablesPriceGreaterThan(vegPrice);
	}

}