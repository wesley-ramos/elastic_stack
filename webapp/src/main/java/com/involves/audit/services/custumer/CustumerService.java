package com.involves.audit.services.custumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustumerService {
	
	private ApplicationEventPublisher publisher;
	private CustumerRepository custumerRepository;
	
	@Autowired
	public CustumerService(CustumerRepository custumerRepository, ApplicationEventPublisher publisher) {
		this.custumerRepository = custumerRepository;
		this.publisher = publisher;
	}
	
	@Transactional
	public void save(Custumer custumer) {
		
		Custumer custumerEntity = custumerRepository.save(custumer);
		
		publisher.publishEvent(new CustumerCreatedEvent("wesley.ramos", custumerEntity));
	}
}
