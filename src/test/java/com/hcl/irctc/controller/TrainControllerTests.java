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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.irctc.dto.TrainResponseDto;
import com.hcl.irctc.exception.IrctcException;
import com.hcl.irctc.model.Day;
import com.hcl.irctc.model.Train;
import com.hcl.irctc.service.ITrainService;

@SpringBootTest
public class TrainControllerTests {
	
	@Mock
	ITrainService trainService;

	 @InjectMocks
	TrainController trainController;

	 static Train train;
	static Train train1;
	static List<Train> list;
	static Day day;
	static List<TrainResponseDto> trainResponseDtoList;
	static TrainResponseDto trainResponseDto;

	 @BeforeAll
	public static void setUp() {

	 list = new ArrayList<Train>();
	train = new Train();
	train.setTrainId(1);
	train.setTrainName("kakatiya");
	train.setTrainNumber(12345);
	train.setSource("hyderabad");
	train.setDestination("benguluru");
	train.setDay(day);
	train.setCostPerSeat(200);
	train.setSeats(400);

	 train1 = new Train();
	train1.setTrainId(2);
	train1.setTrainName("sathavahana");
	train1.setTrainNumber(45678);
	train1.setSource("hyderabad");
	train1.setDestination("delhi");
	train1.setDay(day);
	train1.setCostPerSeat(300);
	train1.setSeats(500);

	 list.add(train);
	list.add(train1);
	
	trainResponseDtoList=ITrainService.convertTraintoTrainResponseDto(list);

	 }

	 @Test
	@DisplayName(" Get TrainDetails:Positive Scenario")
	public void getProductByNameTest() throws IrctcException {
	// context
	when(trainService.searchTrainByLocation("hyderabad", "delhi", day)).thenReturn(new ResponseEntity<List<TrainResponseDto>>(trainResponseDtoList,HttpStatus.OK));

	 // event
	ResponseEntity<List<TrainResponseDto>> result = trainController.searchTrain("hyderabad", "delhi", day);

	 // outcome
	assertEquals(trainResponseDtoList, result.getBody());
	}

	 @Test
	@DisplayName(" Get TrainDetails:Negative Scenario")
	public void getProductByNameTest2() throws IrctcException {
	when(trainService.searchTrainByLocation("hyderabad", "delhi", day)).thenThrow(IrctcException.class);
	 assertThrows(IrctcException.class, () -> trainController.searchTrain("hyderabad", "delhi", day));

	 }

}
