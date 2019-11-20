package com.eventoapi.eventoapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventoapi.eventoapi.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByEmail(String email);
}
