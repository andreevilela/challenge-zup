package com.andre.challenge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.challenge.dto.UserDTO;
import com.andre.challenge.entities.User;
import com.andre.challenge.repositories.UserRepository;
import com.andre.challenge.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

		public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return list.stream().map(e -> new UserDTO(e)).collect(Collectors.toList());
	}
	
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		//return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new UserDTO(entity);
	}
	
	public UserDTO insert(UserDTO dto) {
		User entity = dto.toEntity();
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

}
