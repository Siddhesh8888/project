package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


@Entity
@Table(name = "properties")
public class Property extends BaseEntity{
	
	private int registrationId;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 100)
	private String description;
	
	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
	
	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private PropertyFor propertyFor;
	
	private double area;
	private int rooms;
	
	@Embedded
	private Address address;
	private double price;
	
	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(length = 300)
	private String amenities;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@ManyToOne
	@JoinColumn(name = "buyer_id")
	private Buyer buyer;
	
	@OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Appointment> appointments = new ArrayList<Appointment>();
	
	
	

}
