package com.cg.onlinevegetablestore.service;

import java.util.List;


import org.springframework.http.ResponseEntity;


import com.cg.onlinevegetablestore.entity.Admin;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;


public interface IAdminService {
	// Adding new admin
	public Admin addAdmin(Admin admin);
	// Getting all admins
	public List<Admin> getAllAdmins();
	// Getting admin by Id
	public Admin getAdminById(Long adminId) throws ResourceNotFoundException;
	// Updating admin
	public Admin updateAdmin(Admin adminDetails, Long adminId) throws ResourceNotFoundException;
	// deleting admin
	public void deleteAdmin(Long adminId)throws ResourceNotFoundException;
	// Getting admin by username
	public Admin findByAdminName(String adminName)throws ResourceNotFoundException;
}



