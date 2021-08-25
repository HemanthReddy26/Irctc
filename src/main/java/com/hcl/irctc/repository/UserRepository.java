package com.hcl.irctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.irctc.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
