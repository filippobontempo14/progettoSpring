package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.dto.request.RecensioneFilmConIdDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Utente implements UserDetails{

	private String nome;
	private LocalDate data;
	private String email;
	private String password;
	private boolean bloccato;
	//private boolean admin;
	private Ruolo ruolo;
	
	@OneToMany(mappedBy = "utente", cascade=CascadeType.MERGE)
	private List<Recensione> recensioniUtente = new ArrayList<>();
	@OneToMany
	(mappedBy = "uid", cascade=CascadeType.MERGE)
	private List<UtenteFilm> utenteFilm = new ArrayList<>();
	@OneToMany
	(mappedBy = "usid", cascade=CascadeType.MERGE)
	private List<UtenteSerie> utenteSerie = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public Utente() {
		
	}
	
	public Utente(String nome, LocalDate data) {
		this.nome = nome;
		this.data = data;
	}
	
	
	public Utente(String nome, LocalDate data, String email, String password) {
		this.nome = nome;
		this.data = data;
		this.email = email;
		this.password = password;
	}


	public Utente(String email, String password) {
		this.email = email;
		this.password = password;
	}

	
	public Utente(String nome, LocalDate data, String email, String password, boolean bloccato, Ruolo ruolo) {
		
		this.nome = nome;
		this.data = data;
		this.email = email;
		this.password = password;
		this.bloccato = bloccato;
		this.ruolo = ruolo;
	}

	public Utente(String nome, LocalDate data, String email, String password, boolean bloccato) {
		
		this.nome = nome;
		this.data = data;
		this.email = email;
		this.password = password;
		this.bloccato = bloccato;
		this.id=id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {//ritorna una lista di ruoli che saranno le nostre autorizzazioni
		return List.of(new SimpleGrantedAuthority("ROLE_"+ruolo.getNome()));
	}

	@Override
	public String getUsername() {
		return email;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return !bloccato;
	}

	


	
	
	
}
