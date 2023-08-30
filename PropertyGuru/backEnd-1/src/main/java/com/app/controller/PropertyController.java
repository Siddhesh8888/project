package com.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.DTO.propertyDTO;
import com.app.Entities.Property;
import com.app.exception.resourceNotFoundException;
import com.app.service.propertyServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/properties")
@CrossOrigin(origins = "http://localhost:3000")
public class PropertyController {
	
	@Autowired
	private propertyServiceImpl propServ;
	
	
	@PostMapping
	public ResponseEntity<String> addnewProperty(@RequestBody propertyDTO property){
		System.out.println(property);
		return propServ.addNewProperty(property);
	}
	
	@GetMapping
	public List<Property> getAllProperties(){
		return propServ.getAllProperties();
	}
	
	@DeleteMapping("/{propid}")
	public ResponseEntity<String> deleteProperty(@PathVariable Long propid){
		return propServ.deleteProperty(propid);
	}
	
	@PutMapping
	public ResponseEntity<String> updateProperty(@RequestBody propertyDTO property) throws resourceNotFoundException{
		
		return propServ.updateProperty(property);
	}
	
	@GetMapping("/city")
	public List<Property> getAllPropertiesInCity(String city){
		return propServ.getAllPropertiesInCity(city);
	} 	
	
	@GetMapping("/type")
	public List<Property> getAllPropertiesByType(String type){
		return propServ.getAllPropertiesByType(type);
	} 
	
	@GetMapping("/propertFor")
	public List<Property> getAllPropertiesByPropertyFor(String propfor){
		return propServ.getAllPropertiesByPropertyFor(propfor);
	}
	
    
    @GetMapping("/get/{propId}")
    public Property getPropertyById(@PathVariable Long propId) {
    	
    System.out.println(propServ.getPropertyById(propId).getOwner().getEmail());
    	return propServ.getPropertyById(propId);
    }
    
    @GetMapping("/approved")
	public List<Property> getAllApprovedProperties(){
		return propServ.getAllApprovedProperties();
	}
    
    
    
    
    
}
