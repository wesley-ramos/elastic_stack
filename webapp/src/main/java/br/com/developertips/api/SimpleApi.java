package br.com.developertips.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SimpleApi {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleApi.class);
	
	@GetMapping(value= "/")
	public void api() {	
		logger.error("Log de exemplo ");
	}
}
