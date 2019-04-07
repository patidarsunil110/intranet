package com.idbiintech.intranet.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class EmployeeSecurity extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder authentication) throws Exception {

	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().anyRequest().hasRole("EMPLOYEE").and().formLogin().loginPage("/index.jsp").failureUrl("/index.jsp").loginProcessingUrl("/login").permitAll().and().logout().logoutSuccessUrl("/welcome.jsp");
	}
}