package com.cg.onlinevegetablestore.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinevegetablestore.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	Optional<Customer> findByUserNameAndEmail(String userName, String Email);

}
