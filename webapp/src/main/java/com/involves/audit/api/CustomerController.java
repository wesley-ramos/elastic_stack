package com.involves.audit.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.involves.audit.services.customer.CustomerDTO;
import com.involves.audit.services.customer.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService  customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/save")
	private void save (@RequestBody CustomerDTO customerDTO) {
		customerService.save(customerDTO);
	}
}
