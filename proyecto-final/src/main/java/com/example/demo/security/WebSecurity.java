package com.example.demo.security;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().configurationSource(request -> {
			var cors = new CorsConfiguration();
			cors.setAllowedOrigins(List.of("*"));
			cors.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
			cors.setAllowedHeaders(List.of("*"));
			return cors;
		});
		
		
		
		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors().and().csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/v1/vehiculos","/api/v1/vehiculos/{numeroReserva}", "/api/v1/clientes", "/api/v1/clientes/auth/**")
		.permitAll()
		.anyRequest().authenticated().and()
		.addFilter(new JWTAuthorizationFilter(authenticationManager()));
		
	}
}
