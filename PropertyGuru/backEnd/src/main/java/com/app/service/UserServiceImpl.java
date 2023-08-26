package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.UserDTO;
import com.app.entities.User;
import com.app.repository.UserRepository;

@Service
@Transactional

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDTO getUserByEmail(String email) {
		User user = userRepo.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("User not found : Invalid email"));
		UserDTO userDto = mapper.map(user, UserDTO.class);
		return userDto;
	}
	
	

}
