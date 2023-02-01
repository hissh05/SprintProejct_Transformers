package com.cg.onlinevegetablestore.service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cg.onlinevegetablestore.entity.Image;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.repository.ImagesRepository;
import com.cg.onlinevegetablestore.repository.VegetablesRepository;

@Service
public class ImagesServiceImp implements IImagesService {
	@Autowired
	ImagesRepository imageRepository;

	@Autowired
	VegetablesRepository vegetablesRepository;

	@Override
	public Optional<Object> addImage(Long vegetablesId, MultipartFile file) throws IOException {
		Image img = new Image(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
		return vegetablesRepository.findById(vegetablesId).map(vegetables -> {
			img.setVegetables(vegetables); 
			return imageRepository.save(img);
		});
	}
	
	@Override
	public Image getImageByVegetablesId(Long vegetablesId) {
		final Optional<Image> retrievedImage = imageRepository.findByVegetables_VegetablesId(vegetablesId);
		Image img = new Image(retrievedImage.get().getImageName(), 
				retrievedImage.get().getImageType(),
				decompressByte(retrievedImage.get().getPicByte()));
		img.setImageId(retrievedImage.get().getImageId());
		return img;
	}

	@Override
	public List<Image> getAllImages() {
		List<Image> images = imageRepository.findAll();

		for (Image image : images) {
			Image newImage = image;
			image.setPicByte(decompressByte(newImage.getPicByte()));
		}

		return images;
	}

	@Override
	public Optional<Object> updateImage(Long vegetablesId, MultipartFile file) throws IOException {
		Image img = imageRepository.findByVegetables_VegetablesId(vegetablesId).get();
		img.setImageName(file.getOriginalFilename());
		img.setImageType(file.getContentType());
		img.setPicByte(compressBytes(file.getBytes()));

		return vegetablesRepository.findById(vegetablesId).map(vegetables -> {
			img.setVegetables(vegetables);
			return imageRepository.save(img);
		});
	}

	@Override
	public ResponseEntity<?> deleteImage(Long vegetablesId, Long imageId) throws ResourceNotFoundException {

		return imageRepository.findByImageIdAndVegetables_VegetablesId(imageId, vegetablesId).map(image -> {
			imageRepository.delete(image);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Image not found for this id :: " + vegetablesId));
	}

	private byte[] compressBytes(byte[] data) {
		// TODO Auto-generated method stub

		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}
	
	private byte[] decompressByte(byte[] data) {
		// TODO Auto-generated method stub
		
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
		
	}
}