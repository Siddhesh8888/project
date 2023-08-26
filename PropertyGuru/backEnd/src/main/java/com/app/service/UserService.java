package com.app.service;

import com.app.dto.UserDTO;

public interface UserService {
	
	UserDTO getUserByEmail(String email);

}
