package com.cg.onlinevegetablestore.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.cg.onlinevegetablestore.entity.Image;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;


public interface IImagesService {
	public Optional<Object> addImage(Long vegetablesId,MultipartFile file) throws IOException;
	public Image getImageByVegetablesId(Long vegetablesId);
	public List<Image> getAllImages();
	public Optional<Object> updateImage(Long vegetablesId,MultipartFile file) throws IOException;
    public ResponseEntity<?> deleteImage(Long vegetablesId,Long imageId) throws ResourceNotFoundException;
}