package com.involves.audit.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.involves.audit.services.form.FormDTO;
import com.involves.audit.services.form.FormService;

@RestController
@RequestMapping("/form")
public class FormController {
	
	private FormService formService;
	
	@Autowired
	public FormController(FormService formService) {
		this.formService = formService;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/save")
	private void save (@RequestBody FormDTO formDTO) {
		formService.save(formDTO);
	}
}
