package com.andre.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andre.challenge.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
