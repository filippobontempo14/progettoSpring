package com.example.demo.security;

import java.awt.RenderingHints.Key;
import java.security.SignatureException;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

import com.example.demo.model.Utente;
import com.example.demo.service.UtenteService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GestoreToken {

	private final static String SECRET_KEY="nostraChiaveCheDevoCambiarePercheLaChiaveEraCorta";
	
	private final UtenteService service;
	
	private SecretKey getSignKey() {//cripta la chiave
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}
	
	public String generaToken(Utente u) {
		String ruolo=u.getRuolo().getNome();
		String username=u.getUsername();//ritorna la mail
		long durataToken=1000L*60*60*24*60;
		String token=Jwts.builder()
				.claims()
				.add("ruolo", ruolo)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+durataToken))
				.and()
				.signWith(getSignKey())
				.compact();
		return token;
	}
	
	private Claims estraiClaims(String token) {
		return Jwts
				.parser()
				.verifyWith(getSignKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
				
	}
	
	public String getUsername(String token) {
		return estraiClaims(token).getSubject();
	}
	
	private Date dataScadenza(String token) {
		return estraiClaims(token).getExpiration();
	}
	
	public boolean isTokenScaduto(String token) {
		return dataScadenza(token).before(new Date());
	}
	
	public void isTokenValido(String token){
		String email=getUsername(token);
		Utente u=service.getByEmail(email);
		boolean b1=u.isAccountNonLocked();
		boolean b2=!isTokenScaduto(token);
		if(!(b1&&b2)) throw new MalformedJwtException("token non valido");
	}
}










