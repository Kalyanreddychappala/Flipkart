package com.durga.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private String email;
	private String password;
	private String fname;
	private String lname;
	private Date dob;
	private Long phno;

}
