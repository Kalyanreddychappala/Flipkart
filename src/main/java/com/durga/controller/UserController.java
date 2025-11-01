package com.durga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.durga.dto.UserDto;
import com.durga.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/users")
	public ResponseEntity<UserDto> add(@RequestBody UserDto dto){
		UserDto response=service.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@GetMapping("/get/{email}")
	public ResponseEntity<UserDto> get(@PathVariable String email){
		UserDto response=service.get(email);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@PutMapping("/udpate/{email}")
	public ResponseEntity<UserDto> update(@PathVariable String email, @RequestBody UserDto dto){
		UserDto response=service.update(email, dto);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@DeleteMapping("/delete/{email}")
	public ResponseEntity<String> delete(@PathVariable String email){
		service.delete(email);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User Deleted successfully");
	}
}
