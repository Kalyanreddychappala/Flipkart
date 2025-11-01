package com.durga.login;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginEntity {
	@Id
	@Column(name="user_email")
	private String email;
	@Column(name="password")
	private String password;

}
