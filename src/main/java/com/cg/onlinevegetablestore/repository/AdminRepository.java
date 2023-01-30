package com.cg.onlinevegetablestore.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.onlinevegetablestore.entity.Admin;


public interface AdminRepository  extends JpaRepository<Admin, Long> {
	Optional<Admin> findByUsernameAndEmail(String useerName, String email);
}
