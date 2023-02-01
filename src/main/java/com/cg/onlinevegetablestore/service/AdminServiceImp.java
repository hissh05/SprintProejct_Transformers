package com.cg.onlinevegetablestore.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.entity.Admin;
import com.cg.onlinevegetablestore.repository.AdminRepository;


@Service
public class AdminServiceImp implements IAdminService{
	
	// reference for AdminRepository
	@Autowired
	private AdminRepository adminRepository;
	
	// create admin
	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	// Get admin
	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	// get admin by id
	@Override
	public Admin getAdminById(Long adminId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin Not found"));
	}
	
	// update admin
	@Override
	public Admin updateAdmin(Admin adminDetails, Long adminId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Admin existingAdmin = adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin Not found"));

		existingAdmin.setFirstName(adminDetails.getFirstName());
		existingAdmin.setEmail(adminDetails.getEmail());
		existingAdmin.setPassword(adminDetails.getPassword());
		
		adminRepository.save(existingAdmin);
		return existingAdmin;
	}
	
//	delete admin
	@Override
	public void deleteAdmin(Long adminId) {
		
		adminRepository.deleteById(adminId);
		
	}

	// find admin by username
	@Override
	public Admin findByAdminName(String adminName) {
		
		return adminRepository.findByUsername(adminName);
	}
	
	
}