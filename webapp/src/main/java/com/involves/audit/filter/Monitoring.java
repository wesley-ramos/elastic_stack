package com.involves.audit.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.prometheus.client.Counter;

@Component
@Order(1)
public class Monitoring implements Filter {
	
	private static final Counter REQUEST_COUNT = Counter.build()
		.name("api_request_count")
		.help("API request count")
		.labelNames("url")
		.register();
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String url = ((HttpServletRequest)request).getRequestURI().toString();
		
		REQUEST_COUNT
			.labels(url)
			.inc();
			             
		MDC.put("tracking", UUID.randomUUID().toString());
		
		try {
			chain.doFilter(request, response);
		} finally {
			 MDC.clear();
		}
	}
}
