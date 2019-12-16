package com.involves.audit.api;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.involves.audit.services.form.Form;
import com.involves.audit.services.form.FormDTO;
import com.involves.audit.services.form.FormService;

@RestController
@RequestMapping("/form")
public class FormController {
	
	private Logger logger = LoggerFactory.getLogger(FormController.class);
	private ModelMapper modelMapper;
	private FormService formService;
	
	@Autowired
	public FormController(FormService formService, ModelMapper modelMapper) {
		this.formService = formService;
		this.modelMapper = modelMapper;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/save")
	private void save (@RequestBody FormDTO formDTO) {
		
		Form form = modelMapper.map(formDTO, Form.class);
		try {
			formService.save(form);
		}catch (Exception ex) {
			logger.error("Não foi possível salvar o formulario {}", formDTO.getName());
			
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			
			logger.error(sw.toString());
		}
	}
}
