package com.example.demo.security;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.model.Utente;
import com.example.demo.service.UtenteService;

import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter{
	
	private final GestoreToken gestoreToken;
	private final UtenteService service;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		String token = request.getHeader("Authorization");
		
		if(token!=null && token.startsWith("Baerer")) {
			token=token.substring(7);
			try {
				gestoreToken.isTokenValido(token);
			}catch(MalformedJwtException e) {
				response.sendError(HttpStatus.FORBIDDEN.value(),"token non valido");
				return;
			}
			Utente u = service.getByEmail(gestoreToken.getUsername(token));
			if(SecurityContextHolder.getContext().getAuthentication()==null) {
				UsernamePasswordAuthenticationToken upat=new UsernamePasswordAuthenticationToken(u,null,u.getAuthorities());
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upat);
			}
		}
		filterChain.doFilter(request, response);
	}
	
	
}
