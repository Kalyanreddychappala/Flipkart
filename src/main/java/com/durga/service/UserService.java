package com.durga.service;

import com.durga.dto.UserDto;

public interface UserService {
	
	public UserDto create(UserDto dto);
	public UserDto get(String email);
	public UserDto update(String email,UserDto dto);
	public void delete(String email);

}
