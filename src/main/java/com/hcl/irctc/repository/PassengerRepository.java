package com.hcl.irctc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.irctc.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
	
	public List<Passenger> findPassengerByUserUserId(int userId);

}
