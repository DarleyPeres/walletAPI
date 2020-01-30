package com.wallet.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;
	@Length(min=3, max=50, message="Invalid name.(Name between 3 and 50)")
	private String name;
	@NotNull
	@Length(min=6, message="Password must contain at least 6 characteres")
	private String password;
	@Email(message="Invalid email")
	private String email;
}
