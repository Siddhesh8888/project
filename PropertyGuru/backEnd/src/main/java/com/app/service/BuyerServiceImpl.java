package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.BuyerDTO;
import com.app.entities.Buyer;
import com.app.entities.Role;
import com.app.repository.BuyerRepository;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService{

	@Autowired
	private BuyerRepository buyerRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String registerBuyer(BuyerDTO buyer) {
		System.out.println(buyer);
		Buyer buyer2 = mapper.map(buyer, Buyer.class);
		System.out.println(buyer2);
		buyer2.setUserRole(Role.ROLE_BUYER);
		buyerRepo.save(buyer2);
		return "You registered successfully!!";
	}

	@Override
	public List<Buyer> getAllBuyers() {
		
		return buyerRepo.findAll();
	}

	@Override
	public Buyer getBuyerById(Long buyerId) {
		Buyer buyer = buyerRepo.findById(buyerId).orElseThrow(()->new ResourceNotFoundException("Invalid buyer id!!"));
		return buyer;
	}

	@Override
	public String updateDetails(BuyerDTO buyer) {
		Buyer buyer2 = buyerRepo.findById(buyer.getId()).orElseThrow(()->new ResourceNotFoundException("Invalid buyer id!!"));
		buyer2.setFirstName(buyer.getFirstName());
		buyer2.setLastName(buyer.getLastName());
		buyer2.setAddress(buyer.getAddress());
		buyer2.setEmail(buyer.getEmail());
		buyer2.setPassword(buyer.getPassword());
		buyer2.setContactNumber(buyer.getContactNumber());
		buyerRepo.save(buyer2);
		return "updated successfully!!";
	}

	@Override
	public String deleteBuyer(Long buyerId) {
		if(buyerRepo.existsById(buyerId))
		{
			buyerRepo.deleteById(buyerId);
			return "deleted successfully!!";
		}
		return "Invalid Id!!";
	}
	
	

}
