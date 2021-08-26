package com.hcl.irctc.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.hcl.irctc.model.Day;

public class TrainResponseDto {

	
	public TrainResponseDto() {
		super();

	}

	private int trainId;

	private int trainNumber;

	private String trainName;

	private String source;

	private String destination;

	private float costPerSeat;

	private int seats;
	
	@Enumerated(EnumType.STRING)
	private Day day;

	
	
	public TrainResponseDto(int trainId, int trainNumber, String trainName, String source, String destination, float costPerSeat,
			int seats, Day day) {
		super();
		this.trainId = trainId;
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.costPerSeat = costPerSeat;
		this.seats = seats;
		this.day = day;
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public float getCostPerSeat() {
		return costPerSeat;
	}

	public void setCostPerSeat(float costPerSeat) {
		this.costPerSeat = costPerSeat;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	
}
