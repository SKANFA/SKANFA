package com.github.skanfa.core;

import javax.servlet.Filter;

import org.apache.catalina.filters.RequestDumperFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.proselyte.jwtappdemo.service.impl.UserServiceImpl;

@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		// register(CodeFromVkService.class);
		register(UserServiceImpl.class);
	}

	@Bean
	public FilterRegistrationBean requestDumperFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		Filter requestDumperFilter = new RequestDumperFilter();
		registration.setFilter(requestDumperFilter);
		registration.addUrlPatterns("/*");
		return registration;
	}
}
