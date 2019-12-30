package com.involves.audit.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
	
	private ApplicationEventPublisher publisher;
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository, ApplicationEventPublisher publisher) {
		this.customerRepository = customerRepository;
		this.publisher = publisher;
	}
	
	@Transactional
	public void save(Customer customer) {
		
		Customer customerEntity = customerRepository.save(customer);
		
		publisher.publishEvent(new CustomerCreatedEvent("wesley.ramos", customerEntity));
	}
}
