package com.involves.audit.services.form;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.involves.audit.configuration.AppConfiguration;

@Service
public class FormService {
	
	private ModelMapper modelMapper;
	private ApplicationEventPublisher publisher;
	private FormRepository formRepository;
	
	@Autowired
	public FormService(ModelMapper modelMapper, FormRepository formRepository, ApplicationEventPublisher publisher) {
		this.modelMapper = modelMapper;
		this.formRepository = formRepository;
		this.publisher = publisher;
	}
	
	@Transactional
	public void save(FormDTO formDTO){
		Form form = modelMapper.map(formDTO, Form.class);
		Form entity = formRepository.save(form);
		
		publisher.publishEvent(new FormCreatedEvent(AppConfiguration.USER_NAME, entity));
	}
}
