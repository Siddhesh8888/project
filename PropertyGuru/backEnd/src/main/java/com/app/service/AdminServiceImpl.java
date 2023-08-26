package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AdminDTO;
import com.app.entities.Buyer;
import com.app.entities.Role;
import com.app.entities.User;
import com.app.repository.AdminRepository;
import com.app.repository.BuyerRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public String registerAdmin(AdminDTO admin) {
		User admin2 = mapper.map(admin, User.class);
		admin2.setUserRole(Role.ROLE_ADMIN);
		adminRepo.save(admin2);
		return "You registered successfully!!";
	}
	
	

}
