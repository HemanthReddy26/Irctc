package com.hcl.irctc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.hcl.irctc.dto.BookingResponseDto;
import com.hcl.irctc.exception.IrctcException;
import com.hcl.irctc.model.Booking;

public interface IBookingService {
	
	public ResponseEntity<String> addBooking(int userId,int trainId) throws IrctcException ;
	
	public ResponseEntity<List<BookingResponseDto>> booking(int userId) throws IrctcException;
	

	public static List<BookingResponseDto> convertBookingToBookingResponseDto(List<Booking> bookingList){
		List<BookingResponseDto> bookingResponseDtoList=new ArrayList<>();
		bookingList.forEach(e->{
			BookingResponseDto bookingResponseDto=new BookingResponseDto();
			BeanUtils.copyProperties(e,bookingResponseDto);
			bookingResponseDtoList.add(bookingResponseDto);
		});
		return bookingResponseDtoList;
		
	}

}
