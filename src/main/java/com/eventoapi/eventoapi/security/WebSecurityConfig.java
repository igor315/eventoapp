package com.eventoapi.eventoapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new AuthenticationSuccessHandlerImpl();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()		
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/")
					.permitAll()
				.antMatchers(HttpMethod.GET, "/cadastrarEvento")
					.permitAll() 
				.antMatchers(HttpMethod.POST, "/cadastrarEvento")
					.permitAll() 
				.and()
					.formLogin()
						.loginPage("/login")
						.successHandler(authenticationSuccessHandler())
						.permitAll()
				.and()
					.logout()
						.logoutUrl("/logout")
						.permitAll();
	}

}
