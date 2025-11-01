package com.durga.login.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.durga.dto.UserDto;

public interface LoginService extends UserDetailsService {
	
	public UserDto loadByEmail(String email);

}
