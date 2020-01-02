package com.involves.audit.configuration;

import java.net.DatagramSocket;
import java.net.SocketException;

import javax.servlet.http.HttpServlet;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.involves.audit.filter.Monitoring;

import io.prometheus.client.exporter.MetricsServlet;

@Configuration
public class AppConfiguration {
	
	public static String USER_NAME = "wesley.ramos";
	public static String APPLICATION_NAME = "devepoler";

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public DatagramSocket logstash() throws SocketException {
		return new DatagramSocket();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public ServletRegistrationBean<HttpServlet> metrics() {

		ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
		servRegBean.setServlet(new MetricsServlet());
		servRegBean.addUrlMappings("/metrics");
		servRegBean.setLoadOnStartup(1);
		return servRegBean;
	}

	@Bean
	public FilterRegistrationBean<Monitoring> loggingFilter() {
		FilterRegistrationBean<Monitoring> monitoring = new FilterRegistrationBean<>();

		monitoring.setFilter(new Monitoring());
		monitoring.addUrlPatterns("*");

		return monitoring;
	}
}
