package com.hcl.irctc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int passengerId;
	
	@Column(name="passenger_name")
	private String passengerName;
	
	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="aadhar_no")
	private long aadharNo;
	
	@Column(name="address")
	private String address;

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(int passengerId, String passengerName, int age, String gender, long aadharNo, String address) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.age = age;
		this.gender = gender;
		this.aadharNo = aadharNo;
		this.address = address;
	}
	
	

}
