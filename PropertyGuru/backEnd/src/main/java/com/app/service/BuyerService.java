package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.BuyerDTO;
import com.app.entities.Buyer;

public interface BuyerService {

	String registerBuyer(BuyerDTO buyer);

	List<Buyer> getAllBuyers();

	Buyer getBuyerById(Long buyerId);

	String updateDetails(BuyerDTO buyer);

	String deleteBuyer(Long buyerId);
	
	

}
