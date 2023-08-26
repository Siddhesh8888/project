package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Embeddable
public class Address {
	@Column(length = 60)
	private String line1;
	@Column(length = 60)
	private String line2;
	@Column(length = 30)
	private String city;
	@Column(length = 30)
	private String state;
	private int pincode;

}
