package com.durga.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.durga.dto.UserDto;
import com.durga.entity.UserEntity;
import com.durga.repository.UserRepository;
import com.durga.service.UserService;
import com.durga.util.UserUtil;
@Service
public class UserServiceImpl implements UserService {
		@Autowired
		public UserRepository repo;
		@Autowired
		public PasswordEncoder encoder;
	
	@Override
	public UserDto create(UserDto dto) {
		if(repo.findById(dto.getEmail()).isPresent()) {
			throw new RuntimeException("UserEmail Already Existed: "+dto.getEmail());
		}
		UserEntity entity=UserUtil.convertToEntity(dto);
		entity.setPassword(encoder.encode(dto.getPassword()));
		return UserUtil.convertToDto(repo.save(entity));
	}

	@Override
	public UserDto get(String email) {
	if(repo.findById(email).isEmpty()) {
		throw new RuntimeException("User Details Not Existed: "+email);
	}
		return UserUtil.convertToDto(repo.findById(email).get());
	}

	@Override
	public UserDto update(String email, UserDto dto) {
		if(repo.findById(email).isEmpty()) {
			throw new RuntimeException("User Details Not Existed: "+email);
		}
		return UserUtil.convertToDto(repo.save(UserUtil.convertToEntity(dto)));
	}

	@Override
	public void delete(String email) {
		if(repo.findById(email).isEmpty()) {
			throw new RuntimeException("User Details Not Existed: "+email);
		}
		repo.deleteById(email);

	}

}
