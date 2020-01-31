package com.wallet.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Bcrypt {

	public static String encrypt(String rawPassword) {
		if (rawPassword==null) {
			return null;
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(rawPassword);
	}
	
	public static String decrypt(String password) {
		if (password==null) {
			return null;
		}
		
		return password;
	}
}
