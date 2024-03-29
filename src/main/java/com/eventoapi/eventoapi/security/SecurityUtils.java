package com.eventoapi.eventoapi.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityUtils {
	
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}		
		return str.trim().length() == 0;
	}

	public static LoggedUser loggedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication instanceof AnonymousAuthenticationToken) {
			return null;
		}

		return (LoggedUser) authentication.getPrincipal();
	}
	
	public static String encrypt(String rawString) {
		if (isEmpty(rawString)) {
			return null;
		}
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder.encode(rawString);
	}

}
