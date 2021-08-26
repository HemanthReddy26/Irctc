package com.hcl.irctc.service.impl;

import static org.mockito.ArgumentMatchers.any;
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

import com.hcl.irctc.dto.BookingResponseDto;
import com.hcl.irctc.exception.IrctcException;
import com.hcl.irctc.model.Booking;
import com.hcl.irctc.model.Day;
import com.hcl.irctc.model.Passenger;
import com.hcl.irctc.model.Train;
import com.hcl.irctc.model.User;
import com.hcl.irctc.repository.BookingRepository;
import com.hcl.irctc.repository.PassengerRepository;
import com.hcl.irctc.repository.TrainRepository;
import com.hcl.irctc.repository.UserRepository;
import com.hcl.irctc.util.DateTimeUtil;

@SpringBootTest
public class BookingServiceTests {
	
	@Mock
	BookingRepository bookingRepository;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	TrainRepository trainRepository;
	
	@Mock
	PassengerRepository passengerRepository;
	
	@InjectMocks
	BookingServiceImpl bookingServiceImpl;
	
	static Train train;
	static User user;
	static Booking booking;
	static List<BookingResponseDto> bookingDtoList;
	static List<Booking> bookingList;
	static BookingResponseDto bookingResponseDto;
	static List<Passenger> passengerList;
	
	@BeforeAll
	public static void setUp() {
			
		  user=new User(1,"Hemanth","ahr@1234",623428,"ahr@gmail.com",262876283244L);
	        
			train=new Train();
	        train.setTrainId(1);
	        train.setTrainName("saptagiri");
	        train.setTrainNumber(45248);
	        train.setSource("hyderabad");
	        train.setDestination("bangalore");
	        train.setDay(Day.Mon);
	        train.setCostPerSeat(300);
	        train.setSeats(500);
	        
	        passengerList=new ArrayList<Passenger>();
	        passengerList.add(new Passenger(1,"teja",20,"Male",3368836L,"Kuppam",user));
	        passengerList.add(new Passenger(2,"hemanth",23,"Male",3833836L,"Kuppam",user));
	               
	        booking=new Booking();
	        booking.setBookingId(1);
	        booking.setDate(DateTimeUtil.dateTime());
	        booking.setTotalPrice(1200);
	        booking.setTrain(train);
	        booking.setUser(user);
	        booking.setPassengersList(passengerList);
	        
	        bookingList=new ArrayList<Booking>();
	        bookingList.add(booking);
	        
	        bookingResponseDto=new BookingResponseDto();
	        BeanUtils.copyProperties(booking,bookingResponseDto);
	        bookingDtoList=new ArrayList<>();
	        bookingDtoList.add(bookingResponseDto);
	        

	}
	
	@Test
	@DisplayName("AddBooking:Positive Booking")
	public void addBooking1() throws IrctcException {
		when(userRepository.existsById(1)).thenReturn(true);
		when(trainRepository.existsById(1)).thenReturn(true);
		when(passengerRepository.findPassengerByUserUserId(1)).thenReturn(passengerList);
		when(userRepository.getById(1)).thenReturn(user);
		when(trainRepository.getById(1)).thenReturn(train);	
		when(bookingRepository.save(any(Booking.class))).thenReturn(booking);
		assertEquals("Booking done successfully",bookingServiceImpl.addBooking(1, 1).getBody());
	}
	
	@Test
	@DisplayName("AddBooking:Negative Booking1")
	public void addBooking2() throws IrctcException {
		when(userRepository.existsById(1)).thenReturn(false);
		assertThrows(IrctcException.class,()->bookingServiceImpl.addBooking(1, 1));
	}
	
	@Test
	@DisplayName("AddBooking:Negative Booking2")
	public void addBooking3() throws IrctcException {
		when(userRepository.existsById(1)).thenReturn(true);
		when(trainRepository.existsById(1)).thenReturn(false);
		assertThrows(IrctcException.class,()->bookingServiceImpl.addBooking(1, 1));
	}
	
	@Test
	@DisplayName("AddBooking:Negative Booking3")
	public void addBooking4() throws IrctcException {
		when(userRepository.existsById(1)).thenReturn(true);
		when(trainRepository.existsById(1)).thenReturn(true);
		when(passengerRepository.findPassengerByUserUserId(1)).thenReturn(new ArrayList<Passenger>());
		assertThrows(IrctcException.class,()->bookingServiceImpl.addBooking(1, 1));
	}
	
	
	@Test
	@DisplayName("get history: positive case")
	public void history() throws IrctcException {
		when(userRepository.existsById(1)).thenReturn(true);
		when(bookingRepository.findBookingByUserUserId(1)).thenReturn(bookingList);
		assertEquals(bookingDtoList, bookingServiceImpl.booking(1).getBody());
	}
	
	@Test
	@DisplayName("get history: negative case1")
	public void history2() throws IrctcException {
		when(userRepository.existsById(1)).thenReturn(false);
		assertThrows(IrctcException.class, ()->bookingServiceImpl.booking(1));
	}
	
	@Test
	@DisplayName("get history: negative case2")
	public void history3() throws IrctcException {
		when(userRepository.existsById(1)).thenReturn(true);
		when(bookingRepository.findBookingByUserUserId(1)).thenReturn(new ArrayList<Booking>());
		assertThrows(IrctcException.class, ()->bookingServiceImpl.booking(1));
	}

}
