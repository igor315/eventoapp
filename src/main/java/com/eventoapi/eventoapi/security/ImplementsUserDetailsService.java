package com.eventoapi.eventoapi.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.eventoapi.eventoapi.models.Usuario;
import com.eventoapi.eventoapi.repository.UsuarioRepository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = ur.findByLogin(login);
		
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		
		
		if(usuario == null){
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		return new User(usuario.getUsername(), bCryptEncoder.encode(usuario.getPassword()), true, true, true, true, usuario.getAuthorities());
	}

}