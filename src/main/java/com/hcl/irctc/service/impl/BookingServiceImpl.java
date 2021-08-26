package com.hcl.irctc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.irctc.dto.BookingResponseDto;
import com.hcl.irctc.exception.IrctcException;
import com.hcl.irctc.model.Booking;
import com.hcl.irctc.model.Passenger;
import com.hcl.irctc.repository.BookingRepository;
import com.hcl.irctc.repository.PassengerRepository;
import com.hcl.irctc.repository.TrainRepository;
import com.hcl.irctc.repository.UserRepository;
import com.hcl.irctc.service.IBookingService;
import com.hcl.irctc.util.DateTimeUtil;

@Service
public class BookingServiceImpl implements IBookingService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TrainRepository trainRepository;
	
	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public ResponseEntity<List<BookingResponseDto>> booking(int userId) throws IrctcException {
		if(!userRepository.existsById(userId)) {
			throw new IrctcException("UserId does not exists");
		}
		List<Booking> bookingList=bookingRepository.findBookingByUserUserId(userId);
		if(bookingList.isEmpty())
			throw new IrctcException("No Bookings for this user");
		return new ResponseEntity<List<BookingResponseDto>>(IBookingService.convertBookingToBookingResponseDto(bookingList),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> addBooking( int userId, int trainId) throws IrctcException {
		if(!userRepository.existsById(userId)) {
			throw new IrctcException("UserId does not exists");
		}
		
		if(!trainRepository.existsById(trainId)) {
			throw new IrctcException("TrainId does not exists");

		}
		List<Passenger> passengerList = new ArrayList<>();
		passengerList=passengerRepository.findPassengerByUserUserId(userId);
		if(passengerList.isEmpty()) {
			throw new IrctcException("There are no  passengers for this Id");

		}
		Booking booking = new Booking();
		booking.setPassengersList(passengerList);
		booking.setUser(userRepository.getById(userId));
		booking.setTrain(trainRepository.getById(trainId));
		booking.setTotalPrice(booking.getTrain().getCostPerSeat()*booking.getPassengersList().size());
		booking.setDate(DateTimeUtil.dateTime());
		
		bookingRepository.save(booking);
		
		return new ResponseEntity<String>("Booking done successfully",HttpStatus.OK);

		
		
}

}
