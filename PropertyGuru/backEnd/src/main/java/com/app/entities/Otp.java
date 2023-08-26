package com.app.entities;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name = "otps")
public class Otp {
	
	@Id
	@Column(length = 30)
	private String email;
	private int otp;
	
	private LocalTime timestamp;
	
	public Otp()
	{
		this.timestamp = timestamp.now();
	}
	
	public Otp(String email,int otp)
	{
		this.email = email;
		this.otp = otp;
		this.timestamp = timestamp.now();
	}

}
