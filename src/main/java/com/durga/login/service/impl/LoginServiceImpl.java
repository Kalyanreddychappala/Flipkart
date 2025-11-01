package com.durga.login.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.durga.dto.UserDto;
import com.durga.entity.UserEntity;
import com.durga.login.service.LoginService;
import com.durga.repository.UserRepository;
import com.durga.util.UserUtil;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> entity=repo.findById(username);
		UserEntity userEntity=entity.get();
		return new User(userEntity.getEmail(), userEntity.getPassword(), new ArrayList<>());
	}

	@Override
	public UserDto loadByEmail(String email) {
		if(repo.findById(email).isEmpty()) {
			throw new RuntimeException("user details not existed: "+email);
		}
		return UserUtil.convertToDto(repo.findById(email).get());
	}

}
