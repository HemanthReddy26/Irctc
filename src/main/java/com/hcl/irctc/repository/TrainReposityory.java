package com.hcl.irctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.irctc.model.Train;

@Repository
public interface TrainReposityory extends JpaRepository<Train, Integer> {

}
