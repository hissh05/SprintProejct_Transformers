package com.cg.onlinevegetablestore.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.entity.Admin;
import com.cg.onlinevegetablestore.repository.AdminRepository;

@Service
public class AdminServiceImp {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	@Override
	public List<Admiin> getAllAdmins() {
		return adminRepository.findAll();
	}
	
	@Override
	public ResponseEntity<Admin> getAdminById(Long adminId) throws ResourceNotFoundException {
		 Admin admin = adminRepository.findById(adminId)
		          .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));
		        return ResponseEntity.ok().body(admin);
	}
	
	@Override
	public ResponseEntity<Admin> getAdminByUsernameAndEmail(String username, String email)
			throws ResourceNotFoundException {
		Admin admin = adminRepository.findByUsernameAndEmail(username, email)
		          .orElseThrow(() -> new ResourceNotFoundException("Admin not found " ));
		        return ResponseEntity.ok().body(admin);
	}
	
	@Override
	public ResponseEntity<Admin> updateAdmin(Long adminId, Admin adminDetails) throws ResourceNotFoundException {
		 Admin admin = adminRepository.findById(adminId)
			        .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));

		 			admin.setEmail(adminDetails.getEmail());
		 			admin.setLastName(adminDetails.getLastName());
		 			admin.setFirstName(adminDetails.getFirstName());
			        admin.setUsername(adminDetails.getUsername());
			        admin.setPassword(adminDetails.getPassword());
			        
			        
			        final Admin updatedAdmin = adminRepository.save(admin);
			        return ResponseEntity.ok(updatedAdmin);
	}
}
