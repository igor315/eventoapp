package com.eventoapi.eventoapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventoapi.eventoapi.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{
	Evento findByCodigo(long codigo);
}
