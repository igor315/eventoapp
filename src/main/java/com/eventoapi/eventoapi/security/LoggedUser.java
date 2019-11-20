package com.eventoapi.eventoapi.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.eventoapi.eventoapi.models.Usuario;

public class LoggedUser implements UserDetails {

	private static final long serialVersionUID = 406051197425496861L;

	private Usuario usuario;
	private Role role;
	private Collection<? extends GrantedAuthority> roles;
	
	public LoggedUser(Usuario usuario) {
		this.usuario = usuario;
		Role role = Role.USUARIO;
		this.role = role;
		List<SimpleGrantedAuthority> listRoles = new ArrayList<>();
		listRoles.add(new SimpleGrantedAuthority("ROLE_" + role));
		this.roles = listRoles;		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return usuario.getSenha();
	}

	@Override
	public String getUsername() {
		return usuario.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Role getRole() {
		return role;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
