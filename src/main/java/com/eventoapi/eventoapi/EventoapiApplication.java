package com.eventoapi.eventoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EventoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventoapiApplication.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}

}
