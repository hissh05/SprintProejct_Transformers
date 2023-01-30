package com.cg.onlinevegetablestore.service;

import java.util.List;


import org.springframework.http.ResponseEntity;


import com.cg.onlinevegetablestore.entity.Admin;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;

public interface IAdminService {
	public Admin createAdmin(Admin admin);
	public List<Admin> getAllAdmins();
	public ResponseEntity<Admin> getAdminById(Long adminId)
            throws ResourceNotFoundException;
	public ResponseEntity<Admin> getAdminByUsernameAndEmail(String username,
			String email) throws ResourceNotFoundException;
	public ResponseEntity<Admin> updateAdmin(Long adminId,Admin adminDetails) throws ResourceNotFoundException;
}
