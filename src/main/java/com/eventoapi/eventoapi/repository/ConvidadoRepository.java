package com.eventoapi.eventoapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventoapi.eventoapi.models.Convidado;
import com.eventoapi.eventoapi.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
	Iterable<Convidado> findByEvento(Evento evento);
	Convidado findByRg(String rg);
}
