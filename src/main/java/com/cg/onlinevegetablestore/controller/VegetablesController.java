package com.cg.onlinevegetablestore.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinevegetablestore.entity.Vegetables;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.service.IVegitableService;


@RestController
@RequestMapping("/vegetables")
public class VegetablesController {
	//autowiring the service layer in to the controller layer
		@Autowired
		private IVegitableService vegetableService;
		
		@PostMapping("/addvegetables")
		public Vegetables addVegetables(@RequestBody Vegetables veggie) {
			return vegetableService.addVegetables(veggie);
		}
		
		@GetMapping("/getvegetables")
		public List<Vegetables> listAllVegetables(){
			return vegetableService.listAllVegetables();
		}
		
		@GetMapping("/getvegetables/{vegid}")
		public Vegetables getVegetablesById(@PathVariable("vegid") Long vegId)  throws ResourceNotFoundException{
			return vegetableService.getVegetablesById(vegId);
		}
		
		@PutMapping("/updatevegetables/{vegid}")
		public Vegetables updateVegetables(@RequestBody Vegetables veggie,@PathVariable("vegid") Long vegId) throws ResourceNotFoundException{
			return vegetableService.updateVegetables(veggie, vegId);
		}
		
		@DeleteMapping("/deletevegetables/{vegid}")
		public void deleteVegetables(@PathVariable("vegid") Long vegId) {
			vegetableService.deleteVegetables(vegId);
		}
		
		@GetMapping("/findvegetablesbyname/{vegname}")
		public Vegetables findByVegetablesName(@PathVariable("vegname") String vegName) {
			return vegetableService.findByVegetablesName(vegName);
		}
		
		
		@GetMapping("/findvegetablesbyprice1/{vegpr}")
		public List<Vegetables> findByVegetablesPriceLessThan(@PathVariable("vegpr") float vegPrice){
			return vegetableService.findByVegetablesPriceLessThan(vegPrice);
		}
		
		@GetMapping("/findvegetablesbyprice/{vegpr}")
		public List<Vegetables> findByVegetablesPriceGreaterThan(@PathVariable("vegpr")  float vegPrice){
			return vegetableService.findByVegetablesPriceGreaterThan(vegPrice);
		}

	}