package com.cg.onlinevegetablestore.controller;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	//autowiring the service layer in to the controller layer
	@Autowired
	private IAdminService adminService;

	//Create Admin
	@PostMapping("/addadmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	
	// Get Admin
	@GetMapping("/getAdmin")
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmins();
	}
	
	// Get admin by admin Id
	@GetMapping("/getadmin/{adminid}")
	public Admin getAdminById1(@PathVariable("adminid") Long adminId)  throws ResourceNotFoundException{
		return adminService.getAdminById(adminId);
	}
	// update admin
	@PutMapping("/updateadmin/{adminid}")
	public Admin updateAdmin(@RequestBody Admin admin,@PathVariable("adminid") Long adminId) 
			throws ResourceNotFoundException{
			return adminService.updateAdmin(admin, adminId);
	}
	
	// delete admin
	@DeleteMapping("/deleteadmin/{adminid}")
	public void deleteAdmin(@PathVariable("adminid") Long adminId) 
			throws ResourceNotFoundException{
			adminService.deleteAdmin(adminId);
	}
	
	// find admin by username
	@GetMapping("/findadminbyname/{username}")
	public Admin findByAdminName(@PathVariable("username") String adminName) 
			throws ResourceNotFoundException{
			return adminService.findByAdminName(adminName);
	}
	
}