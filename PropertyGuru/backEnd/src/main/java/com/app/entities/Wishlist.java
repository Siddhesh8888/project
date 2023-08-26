package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "wishlist")
public class Wishlist extends BaseEntity{
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "wishlist_property",
	joinColumns = @JoinColumn(name= "wishlist_id"),
	inverseJoinColumns = @JoinColumn(name = "property_id"))
	private List<Property> properties = new ArrayList<Property>();
	
	@OneToOne
	@JoinColumn(name = "buyer_id")
	private Buyer buyer;

}
