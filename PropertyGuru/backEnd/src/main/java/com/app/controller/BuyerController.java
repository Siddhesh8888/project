package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BuyerDTO;
import com.app.entities.Buyer;
import com.app.service.BuyerService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/buyer")
public class BuyerController {
	
	@Autowired
	private BuyerService buyerSer;
	
	@GetMapping
	public List<Buyer> getAllBuyers()
	{
		return buyerSer.getAllBuyers();
	}
	
	@GetMapping("/{buyerId}")
	public Buyer getBuyerDetails(@PathVariable Long buyerId)
	{
		return buyerSer.getBuyerById(buyerId);
	}
	
	@PutMapping
	public ResponseEntity<?> updateBuyerDetails(@RequestBody BuyerDTO buyer)
	{
		return ResponseEntity.status(HttpStatus.OK).body(buyerSer.updateDetails(buyer));
	}
	
	@DeleteMapping("/{buyerId}")
	public ResponseEntity<?> deleteById(@PathVariable Long buyerId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(buyerSer.deleteBuyer(buyerId));
	}

}
