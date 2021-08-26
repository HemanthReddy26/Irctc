package com.hcl.irctc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private int bookingId;

	@ManyToOne
	private Train train;

	@ManyToOne
	private User user;
	
	@Column(name="total_price")
	private float totalPrice;
	
	@Column(name="date")
	private String date;
	
	@OneToMany
	private List<Passenger> passengersList;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Passenger> getPassengersList() {
		return passengersList;
	}

	public void setPassengersList(List<Passenger> passengersList) {
		this.passengersList = passengersList;
	}

	public Booking(int bookingId, Train train, User user, float totalPrice, String date, List<Passenger> passengersList) {
		super();
		this.bookingId = bookingId;
		this.train = train;
		this.user = user;
		this.totalPrice = totalPrice;
		this.date = date;
		this.passengersList = passengersList;
	}

	public Booking() {
		super();
	}

	

}
