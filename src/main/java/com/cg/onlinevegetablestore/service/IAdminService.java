package com.cg.onlinevegetablestore.service;

import java.util.List;


import org.springframework.http.ResponseEntity;


import com.cg.onlinevegetablestore.entity.Admin;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;


public interface IAdminService {
	public Admin addAdmin(Admin admin);
	public List<Admin> getAllAdmins();
	public Admin getAdminById(Long adminId) throws ResourceNotFoundException;
	
	public Admin updateAdmin(Admin adminDetails, Long adminId) throws ResourceNotFoundException;
	public void deleteAdmin(Long adminId);
	public Admin findByAdminName(String adminName);
}


