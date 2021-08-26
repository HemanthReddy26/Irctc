package com.hcl.irctc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.irctc.dto.TrainResponseDto;
import com.hcl.irctc.exception.IrctcException;
import com.hcl.irctc.model.Day;
import com.hcl.irctc.service.ITrainService;

@RestController
public class TrainController {
	
	@Autowired
	ITrainService trainService;

	 @GetMapping("/trains")
	public ResponseEntity<List<TrainResponseDto>> searchTrain(String source, String destination, Day day) throws IrctcException {
	 return trainService.searchTrainByLocation(source, destination, day);

	 }

}
