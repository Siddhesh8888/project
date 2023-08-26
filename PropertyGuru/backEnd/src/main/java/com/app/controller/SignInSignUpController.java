package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AdminDTO;
import com.app.dto.AuthRequestDTO;
import com.app.dto.BuyerDTO;
import com.app.dto.OwnerDTO;
import com.app.dto.UserDTO;
import com.app.service.AdminService;
import com.app.service.BuyerService;
import com.app.service.OwnerService;
import com.app.service.UserService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/auth")
@Validated
public class SignInSignUpController {
	
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	
	
	@PostMapping("/buyer/signup")
	ResponseEntity<?> buyerRegistration(@RequestBody BuyerDTO buyer)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(buyerService.registerBuyer(buyer));
	}
	
	@PostMapping("/owner/signup")
	ResponseEntity<?> ownerRegistration(@RequestBody OwnerDTO owner)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ownerService.registerOwner(owner));
	}
	
	@PostMapping("/admin/signup")
	ResponseEntity<?> adminRegistration(@RequestBody AdminDTO admin)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(adminService.registerAdmin(admin));
	}
	
	@PostMapping("/signin")
	ResponseEntity<?> authenticateUser(@RequestBody @Valid AuthRequestDTO request)
	{
		UserDTO user = userService.getUserByEmail(request.getEmail());
		if(user.getPassword().equals(request.getPassword()))
			return ResponseEntity.status(HttpStatus.OK).body(user);
		return ResponseEntity.status(HttpStatus.OK).body("Authentication failed: invalid email or password");
	}

}
