package com.cg.onlinevegetablestore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinevegetablestore.entity.Admin;
import com.cg.onlinevegetablestore.service.IAdminService;



import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;


@RestController 
@RequestMapping("/api/v1")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;

	
	@PostMapping("/admins")
	public Admin createAdmin(@Valid @RequestBody Admin admin)
	{
		return adminService.createAdmin(admin);
	}
	
	@GetMapping("/admins")
	public List<Admin> getAllAdmins()
	{
		return adminService.getAllAdmins();
	}

	//Get admin by id
	@GetMapping("/admins/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable(value = "id") Long adminId)
        throws ResourceNotFoundException {
		return adminService.getAdminById(adminId);
	}
	
	//Get admin by username and email
	@GetMapping("/admins/{username}/{email}")
	public ResponseEntity<Admin> getAdminByUsernameAndEmail(@PathVariable(value = "username") String username,
			@PathVariable(value = "email") String email) throws ResourceNotFoundException {
		return adminService.getAdminByUsernameAndEmail(username, email);
		}
	
	//update admin
	@PutMapping("/admins/{id}")
    public ResponseEntity<Admin> updateVendor(@PathVariable(value = "id") Long adminId,
         @Valid @RequestBody Admin adminDetails) throws ResourceNotFoundException {
		return adminService.updateAdmin(adminId, adminDetails);
    }

}
