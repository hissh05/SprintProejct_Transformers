package com.cg.onlinevegetablestore.controller;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
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
@RequestMapping("/admin")
public class AdminController {

	//autowiring the service layer in to the controller layer
	@Autowired
	private IAdminService adminService;

	
	@PostMapping("/addadmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	
	@GetMapping("/getAdmin")
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmins();
	}
	
	@GetMapping("/getadmin/{adminid}")
	public Admin getAdminById1(@PathVariable("adminid") Long adminId)  throws ResourceNotFoundException{
		return adminService.getAdminById(adminId);
	}
	
	@PutMapping("/updateadmin/{adminid}")
	public Admin updateAdmin(@RequestBody Admin admin,@PathVariable("adminid") Long adminId) throws ResourceNotFoundException{
		return adminService.updateAdmin(admin, adminId);
	}
	
	@DeleteMapping("/deleteadmin/{adminid}")
	public void deleteAdmin(@PathVariable("adminid") Long adminId) {
		adminService.deleteAdmin(adminId);
	}
	
	@GetMapping("/findadminbyname/{adminname}")
	public Admin findByAdminName(@PathVariable("adminname") String adminName) {
		return adminService.findByAdminName(adminName);
	}
	
}
