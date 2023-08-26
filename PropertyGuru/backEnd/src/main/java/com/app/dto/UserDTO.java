package com.app.dto;

import com.app.entities.Address;
import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class UserDTO {
	
	private Long id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Address address;
	private Long contactNumber;
	private Role userRole;

}
