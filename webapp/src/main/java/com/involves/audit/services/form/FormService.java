package com.involves.audit.services.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FormService {
	
	private Logger logger = LoggerFactory.getLogger(FormService.class);
	private ApplicationEventPublisher publisher;
	private FormRepository formRepository;
	
	@Autowired
	public FormService(FormRepository formRepository, ApplicationEventPublisher publisher) {
		this.formRepository = formRepository;
		this.publisher = publisher;
	}
	
	@Transactional
	public void save(Form form){
		
		throw new RuntimeException("Falhar na comunicação com o banco de dados");
		
		//logger.error("Criando um novo formulario name={}", form.getName());
		//Form entity = formRepository.save(form);
		
		//publisher.publishEvent(new FormCreatedEvent("wesley.ramos", entity));
	}
}
