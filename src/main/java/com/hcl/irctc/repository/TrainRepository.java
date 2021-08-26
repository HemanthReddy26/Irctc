package com.hcl.irctc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.irctc.model.Day;
import com.hcl.irctc.model.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {
	
	public List<Train> findTrainBySourceContainingAndDestinationContainingAndDay(String source,String destination, Day day);

}
