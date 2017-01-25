package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private Long id;

	private String reservationName;

	
	public Reservation(String reservationName) {
		
		this.reservationName = reservationName;
	}

	Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	

	public String getReservationName() {
		return reservationName;
	}

	

	@Override
	public String toString() {
		return "Registration [id=" + id + ", reservationName=" + reservationName + "]";
	}
}
