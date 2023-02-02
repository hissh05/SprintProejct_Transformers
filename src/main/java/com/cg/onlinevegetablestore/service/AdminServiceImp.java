package com.cg.onlinevegetablestore.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.entity.Admin;
import com.cg.onlinevegetablestore.repository.AdminRepository;


@Service
public class AdminServiceImp implements IAdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(Long adminId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin Not found"));
	}

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

	@Override
	public void deleteAdmin(Long adminId) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(adminId);
		
	}

	@Override
	public Admin findByAdminName(String adminName) {
		// TODO Auto-generated method stub
		return adminRepository.findByUsername(adminName);
	}
	
	
}
