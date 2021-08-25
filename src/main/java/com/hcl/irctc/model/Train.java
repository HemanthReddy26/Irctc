package com.hcl.irctc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="train")
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trainId;
	
	@Column(name="train_number")
	private int trainNumber;
	
	@Column(name="train_name")
	private String trainName;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="cost_per_seat")
	private float costPerSeat;
	
	@Column(name="seats")
	private int seats;
	
	@Column(name="day")
	@Enumerated
	private List<Day> day;

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

	public List<Day> getDay() {
		return day;
	}

	public void setDay(List<Day> day) {
		this.day = day;
	}

	public Train(int trainId, int trainNumber, String trainName, String source, String destination, float costPerSeat,
			int seats, List<Day> day) {
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

	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
