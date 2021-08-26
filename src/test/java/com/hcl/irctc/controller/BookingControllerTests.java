package com.hcl.irctc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.irctc.dto.BookingResponseDto;
import com.hcl.irctc.exception.IrctcException;
import com.hcl.irctc.model.Booking;
import com.hcl.irctc.model.Day;
import com.hcl.irctc.model.Passenger;
import com.hcl.irctc.model.Train;
import com.hcl.irctc.model.User;
import com.hcl.irctc.service.IBookingService;
import com.hcl.irctc.util.DateTimeUtil;

@SpringBootTest
public class BookingControllerTests {
	
	@Mock
	IBookingService iBookingService;
	
	@InjectMocks
	BookingController bookingController;
	
	static Train train;
	static User user;
	static Booking booking;
	static List<BookingResponseDto> bookingDtoList;
	static BookingResponseDto bookingResponseDto;
	
	@BeforeAll
	public static void setUp() {
			
		  user=new User(1,"Hemanth","ahr@1234",623428,"ahr@gmail.com",26287628L);
	        
			train=new Train();
	        train.setTrainId(1);
	        train.setTrainName("saptagiri");
	        train.setTrainNumber(45248);
	        train.setSource("hyderabad");
	        train.setDestination("bangalore");
	        train.setDay(Day.Mon);
	        train.setCostPerSeat(300);
	        train.setSeats(500);
	        
	        List<Passenger> passengerList=new ArrayList<Passenger>();
	        passengerList.add(new Passenger(1,"teja",20,"Male",3368836L,"Kuppam",user));
	        passengerList.add(new Passenger(2,"hemanth",23,"Male",3833836L,"Kuppam",user));
	               
	        booking=new Booking();
	        booking.setBookingId(1);
	        booking.setDate(DateTimeUtil.dateTime());
	        booking.setTotalPrice(1200);
	        booking.setTrain(train);
	        booking.setUser(user);
	        booking.setPassengersList(passengerList);
	        
	        bookingResponseDto=new BookingResponseDto();
	        BeanUtils.copyProperties(booking,bookingResponseDto);
	        bookingDtoList=new ArrayList<>();
	        bookingDtoList.add(bookingResponseDto);
	        

	}
	
	@Test
	@DisplayName("AddBookingTrain :Positive Scenario")
	public void testAddBooking3() throws IrctcException {
		when(iBookingService.addBooking(1,2)).thenReturn(new ResponseEntity<String>("booking done successfully",HttpStatus.OK));
		ResponseEntity<String> result= bookingController.addBooking(1,2);
		assertEquals("booking done successfully",result.getBody());

	}
	
	
	@Test
	@DisplayName("AddBooking :Negative Scenario")
	public void testAddBooking4() throws IrctcException {
		when(iBookingService.addBooking(1,2)).thenThrow(IrctcException.class);
		assertThrows(IrctcException.class, ()->bookingController.addBooking(1,2));

	}
	
	@Test
	@DisplayName("get history: positive case")
	public void history() throws IrctcException {
		
		when(iBookingService.booking(1)).thenReturn(new ResponseEntity<List<BookingResponseDto>>(bookingDtoList,HttpStatus.OK));
		
		assertEquals(bookingDtoList,bookingController.bookings(1).getBody());
	}
	
	@Test
	@DisplayName("get history: negative case")
	public void history1() throws IrctcException {
		
		when(iBookingService.booking(1)).thenThrow(IrctcException.class);
		
		assertThrows(IrctcException.class,()->bookingController.bookings(1));
	}


}
