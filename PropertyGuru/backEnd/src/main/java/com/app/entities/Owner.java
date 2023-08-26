package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "owners")
@PrimaryKeyJoinColumn(name = "id")
public class Owner extends User{
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	List<Property> propertyList = new ArrayList<Property>();
	
	//helper method to add property
	public void addProperty(Property property)
	{
		this.propertyList.add(property);
	}

}
