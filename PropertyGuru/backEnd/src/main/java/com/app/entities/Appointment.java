package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

@Entity
@Table(name = "appointments")
public class Appointment extends BaseEntity{
	
	private LocalDate date;
	@Column(length = 30)
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status;
	
	@ManyToOne
	@JoinColumn(name = "buyer_id")
	private Buyer buyer;
	
	@ManyToOne
	@JoinColumn(name = "property_id")
	private Property property;

}
