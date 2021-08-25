package com.hcl.irctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.irctc.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

}
