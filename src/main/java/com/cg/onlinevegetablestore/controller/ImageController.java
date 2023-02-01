package com.cg.onlinevegetablestore.controller;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cg.onlinevegetablestore.entity.Image;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.service.IImagesService;


@RestController 
@RequestMapping("/api/v1")
public class ImageController {
	
	@Autowired
	private IImagesService imageService;
	
	
	//add image for corresponding item
	@PostMapping("/menu/{vegetablesId}/vegetablesImages")
	public Optional<Object> addImage(@PathVariable(value = "vegetablesId") Long vegetablesId,
			@RequestParam("vegetablesImage") MultipartFile file) throws IOException
	{
		return imageService.addImage(vegetablesId, file);
	}
	
	//get corresponding image for vegetables id
	@GetMapping("/menu/{vegetablesId}/vegetablesImages")
	public Image getImageByVegetablesId(@PathVariable(value = "vegetablesId") Long vegetablesId)
	{
		return imageService.getImageByVegetablesId(vegetablesId);
	}

	//get all images
	@GetMapping("/menu/images")
	public List<Image> getAllImages()
	{
		return imageService.getAllImages();
	}
	
	//update responding image by itemId
	@PutMapping("/menu/{vegetablesId}/vegetablesImages")
	public Optional<Object> updateImage(@PathVariable(value = "itemId") Long vegetablesId,
			@RequestParam("vegetablesImage") MultipartFile file) throws IOException
	{
		return imageService.updateImage(vegetablesId, file);
		
	}
	
	//delete image for corresponding itemId
	@DeleteMapping("/menu/{vegetablesId}/vegetablesImages/{imageId}")
    public ResponseEntity<?> deleteImage(@PathVariable(value = "vegetablesId") Long vegetablesId, @PathVariable(value = "imageId") Long imageId)
         throws ResourceNotFoundException {
		return imageService.deleteImage(vegetablesId, imageId);
	}

}