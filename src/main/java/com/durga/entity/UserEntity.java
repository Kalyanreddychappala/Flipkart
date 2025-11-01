package com.durga.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_details")
public class UserEntity {
	
	@Id
	@Column(name="user_email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="first_name")
	private String fname;
	@Column(name="last_name")
	private String lname;
	@Column(name="dob")
	private Date dob;
	@Column(name="phno")
	private Long phno;

}
