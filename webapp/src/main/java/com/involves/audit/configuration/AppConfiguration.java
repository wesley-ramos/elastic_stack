package com.involves.audit.configuration;

import java.net.DatagramSocket;
import java.net.SocketException;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.involves.audit.filter.Monitoring;

@Configuration
public class AppConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public DatagramSocket logstash() throws SocketException{
		return new DatagramSocket();
	}
	
	@Bean
	public ObjectMapper objectMapper (){
		return new ObjectMapper ();
	}
	
	@Bean
	public FilterRegistrationBean<Monitoring> loggingFilter(){
	    FilterRegistrationBean<Monitoring> monitoring  = new FilterRegistrationBean<>();
	         
	    monitoring.setFilter(new Monitoring());
	    monitoring.addUrlPatterns("*");
	         
	    return monitoring;    
	}
}
