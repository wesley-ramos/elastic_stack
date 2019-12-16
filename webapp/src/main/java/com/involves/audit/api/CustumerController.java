package com.involves.audit.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.involves.audit.services.custumer.Custumer;
import com.involves.audit.services.custumer.CustumerDTO;
import com.involves.audit.services.custumer.CustumerService;

@RestController
@RequestMapping("/custumer")
public class CustumerController {
	
	private ModelMapper modelMapper;
	private CustumerService custumerService;
	
	@Autowired
	public CustumerController(CustumerService custumerService, ModelMapper modelMapper) {
		this.custumerService = custumerService;
		this.modelMapper = modelMapper;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/save")
	private void save (@RequestBody CustumerDTO custumerDTO) {
		Custumer user = modelMapper.map(custumerDTO, Custumer.class);
		custumerService.save(user);
	}
}
