package br.com.agenda.core.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtils {
	
	public PasswordUtils() {}
	
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static String encode(String password) {
		return passwordEncoder().encode(password);
	}
}