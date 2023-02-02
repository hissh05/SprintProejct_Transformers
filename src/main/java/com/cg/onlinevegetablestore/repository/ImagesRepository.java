package com.cg.onlinevegetablestore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinevegetablestore.entity.Image;


@Repository
public interface ImagesRepository extends JpaRepository<Image, Long>{
	
	Optional<Image> findByVegetables_VegetablesId(Long vegetablesId);
	Optional<Image> findByImageIdAndVegetables_VegetablesId(Long imageId, Long vegetablesId);

}