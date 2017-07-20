package com.springcrud.despesas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class InMemorySecurityConfig {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder)
			throws Exception {
		builder
		.inMemoryAuthentication()
		.withUser("boca").password("1234").roles("USER")
		.and()
		.withUser("admin").password("admin").roles("USER")
		.and()
		.withUser("1").password("1").roles("USER");
	}
}
