package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.request.RecensioneFilmConIdDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Utente {

	private String nome;
	private LocalDate data;
	private String email;
	private String password;
	private boolean bloccato;
	private boolean admin;
	
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

	
	

	public Utente(String nome, LocalDate data, String email, String password, boolean bloccato, boolean admin) {
		
		this.nome = nome;
		this.data = data;
		this.email = email;
		this.password = password;
		this.bloccato = bloccato;
		this.admin = admin;
		this.id=id;
	}


	public boolean isBloccato() {
		return bloccato;
	}


	public void setBloccato(boolean bloccato) {
		this.bloccato = bloccato;
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public List<Recensione> getRecensioniUtente() {
		return recensioniUtente;
	}


	public void setRecensioniUtente(List<Recensione> recensioniUtente) {
		this.recensioniUtente = recensioniUtente;
	}

	public List<UtenteFilm> getUtenteFilm() {
		return utenteFilm;
	}

	public void setUtenteFilm(List<UtenteFilm> utenteFilm) {
		this.utenteFilm = utenteFilm;
	}

	public List<UtenteSerie> getUtenteSerie() {
		return utenteSerie;
	}

	public void setUtenteSerie(List<UtenteSerie> utenteSerie) {
		this.utenteSerie = utenteSerie;
	}
	
	
	
}
