package com.involves.audit.services.customer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.involves.audit.configuration.AppConfiguration;

@Service
public class CustomerService {
	
	private ModelMapper modelMapper;
	private ApplicationEventPublisher publisher;
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService(ModelMapper modelMapper, CustomerRepository customerRepository, ApplicationEventPublisher publisher) {
		this.modelMapper = modelMapper;
		this.customerRepository = customerRepository;
		this.publisher = publisher;
	}
	
	@Transactional
	public void save(CustomerDTO customerDTO) {
		Customer customer = modelMapper.map(customerDTO, Customer.class);
		Customer entity = customerRepository.save(customer);
		
		publisher.publishEvent(new CustomerCreatedEvent(AppConfiguration.USER_NAME, entity));
	}
}
