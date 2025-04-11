package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.model.Ruolo;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class PathConfigurator {
	
	private final AuthFilter authFilter;
	private final AuthenticationProvider authenticationProvider;
	
	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests(
				auth->auth
				.requestMatchers("/all/**").permitAll()
				.requestMatchers("/admin/**").hasRole(Ruolo.ADMIN.getNome())
				.requestMatchers("/utente/**").hasRole(Ruolo.UTENTE.getNome())
				.anyRequest().authenticated()
				)
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.cors(AbstractHttpConfigurer::disable)
		.authenticationProvider(authenticationProvider)
		.addFilterAfter(authFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
		
	}
}
