package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)

@Entity
@Table(name = "users")
public class User extends BaseEntity{
	
	@Column(length = 30, unique = true)
	private String email;
	@Column(length = 30, nullable = false)
	private String password;
	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;
	@Column(name = "last_name", length = 30, nullable = false)
	private String lastName;
	@Embedded
	private Address address;
	@Column(name = "mobile_number")
	private Long contactNumber;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Role userRole;

}
