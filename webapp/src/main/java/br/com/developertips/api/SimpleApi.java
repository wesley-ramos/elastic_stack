package br.com.developertips.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.elastic.apm.opentracing.ElasticApmTracer;
import io.opentracing.Scope;
import io.opentracing.Tracer;

@RestController
@RequestMapping("/api")
public class SimpleApi {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleApi.class);
	
	@GetMapping(value= "/")
	public void api() {	
		logger.error("Log de exemplo ");
		
		Tracer tracer = new ElasticApmTracer();
	    try (Scope scope = tracer.buildSpan("say-hello").startActive(true)) {
	        scope.span().setTag("hello-to", "wesley");
	    }
	}
}
