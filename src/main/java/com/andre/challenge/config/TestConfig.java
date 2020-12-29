package com.andre.challenge.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andre.challenge.entities.User;
import com.andre.challenge.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "André Vilela", "andre@gmail.com", 
				"11111111111", java.sql.Date.valueOf("1992-05-23"));
		User u2 = new User(null, "João Silva", "joao@gmail.com", 
				"22222222222", java.sql.Date.valueOf("2002-10-06"));
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
