package com.hcl.irctc.controller;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.irctc.dto.BookingResponseDto;
import com.hcl.irctc.exception.IrctcException;
import com.hcl.irctc.service.IBookingService;

@RestController
public class BookingController {
	
	@Autowired
	IBookingService iBookingService;
	
	@GetMapping("/users/{userId}/bookings")
	public ResponseEntity<List<BookingResponseDto>> bookings(@NotNull @Min(1) @PathVariable int userId) throws IrctcException{	
		return iBookingService.booking(userId);
	}
	
	@PostMapping("/tickets/")
	public ResponseEntity<String> addBooking(@RequestParam int userId,@RequestParam int trainId) throws IrctcException {
		return iBookingService.addBooking(userId, trainId);

	}


}
