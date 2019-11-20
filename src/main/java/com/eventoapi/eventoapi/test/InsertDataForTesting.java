package com.eventoapi.eventoapi.test;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InsertDataForTesting {

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {

		// Dados a serem populados no banco quando a aplicação inicar

	}

}
