package com.hcl.irctc.dto;

import java.util.List;

import com.hcl.irctc.model.Passenger;
import com.hcl.irctc.model.Train;
import com.hcl.irctc.model.User;

public class BookingResponseDto {
	
	private int bookingId;

	private Train train;

	private User user;

	private int totalPrice;

	private String date;

	private List<Passenger> passengersList;

	
	
	public BookingResponseDto() {
		super();
	}

	public BookingResponseDto(int bookingId, Train train, User user, int totalPrice, String date,
			List<Passenger> passengersList) {
		super();
		this.bookingId = bookingId;
		this.train = train;
		this.user = user;
		this.totalPrice = totalPrice;
		this.date = date;
		this.passengersList = passengersList;
	}

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

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
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
}
