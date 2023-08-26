package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.OwnerDTO;
import com.app.entities.Owner;
import com.app.entities.Role;
import com.app.repository.OwnerRepository;


@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	private OwnerRepository ownerRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String registerOwner(OwnerDTO owner) {
		Owner owner2 = mapper.map(owner, Owner.class);
		owner2.setUserRole(Role.ROLE_OWNER);
		ownerRepo.save(owner2);
		return "You registered successfully!!";
	}
	
	

}
