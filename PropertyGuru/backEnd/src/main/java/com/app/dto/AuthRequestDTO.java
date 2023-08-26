package com.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class AuthRequestDTO {
	
	@NotBlank(message = "Email can't be blank!!")
	private String email;
	@NotBlank(message = "Password can't be blank!!")
	private String password;

}
