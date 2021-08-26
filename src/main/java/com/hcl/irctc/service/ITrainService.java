package com.hcl.irctc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.hcl.irctc.dto.TrainResponseDto;
import com.hcl.irctc.exception.IrctcException;
import com.hcl.irctc.model.Day;
import com.hcl.irctc.model.Train;

public interface ITrainService {
	
	public ResponseEntity<List<TrainResponseDto>> searchTrainByLocation(String source,String destination,Day day) throws IrctcException;
	
	public static List<TrainResponseDto> convertTraintoTrainResponseDto(List<Train> trainList){
		List<TrainResponseDto> trainResponseDtoList=new ArrayList<TrainResponseDto>();
		trainList.forEach(train->{
			TrainResponseDto trainResponseDto=new TrainResponseDto();
			BeanUtils.copyProperties(train,trainResponseDto);
			trainResponseDtoList.add(trainResponseDto);			
		});
		
		return trainResponseDtoList;
	}

}
