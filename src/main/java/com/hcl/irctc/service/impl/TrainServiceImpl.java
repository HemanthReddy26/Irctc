package com.hcl.irctc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.irctc.dto.TrainResponseDto;
import com.hcl.irctc.exception.IrctcException;
import com.hcl.irctc.model.Day;
import com.hcl.irctc.model.Train;
import com.hcl.irctc.repository.TrainRepository;
import com.hcl.irctc.service.ITrainService;

@Service
public class TrainServiceImpl implements ITrainService {

	@Autowired
	private TrainRepository trainRepository;

	 @Override
	public ResponseEntity<List<TrainResponseDto>> searchTrainByLocation(String source, String destination, Day day) throws IrctcException {
	List<Train> trainList=trainRepository.findTrainBySourceContainingAndDestinationContainingAndDay(source, destination, day);
	if(trainList.isEmpty())
		throw new IrctcException("Train not available");
	return new ResponseEntity<List<TrainResponseDto>>(ITrainService.convertTraintoTrainResponseDto(trainList),HttpStatus.OK);

	}
}
