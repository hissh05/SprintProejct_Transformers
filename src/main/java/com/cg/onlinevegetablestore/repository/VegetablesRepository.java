package com.cg.onlinevegetablestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinevegetablestore.entity.Vegetables;

public interface VegetablesRepository extends JpaRepository<Vegetables, Long> {

}
