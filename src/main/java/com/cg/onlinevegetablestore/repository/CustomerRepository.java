package com.cg.onlinevegetablestore.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinevegetablestore.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
