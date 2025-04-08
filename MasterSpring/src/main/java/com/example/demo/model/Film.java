package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.request.RecensioneFilmConIdDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Film {
	
	private String titolo;
	private double durata;
	private String genere;
	private boolean bloccato;
	
	@OneToMany
	(mappedBy = "film", fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	private List<Recensione> recensioniFilm = new ArrayList<>();
	//private List<Integer> voti = new ArrayList<>();
	@OneToMany
	(mappedBy = "fid", cascade=CascadeType.MERGE)
	private List<UtenteFilm> utenteFilm = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public Film() {
		
	}

	public Film(String titolo, double durata, String genere, boolean bloccato) {
		
		this.titolo = titolo;
		this.durata = durata;
		this.genere = genere;
		this.bloccato = bloccato;
		this.id=id;
	}

	public Film(String titolo, double durata, String genere) {
		this.titolo = titolo;
		this.durata = durata;
		this.genere = genere;
		this.id=id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public double getDurata() {
		return durata;
	}

	public void setDurata(double durata) {
		this.durata = durata;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public boolean isBloccato() {
		return bloccato;
	}

	public void setBloccato(boolean bloccato) {
		this.bloccato = bloccato;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*public List<Integer> getVoti() {
		return voti;
	}

	public void setVoti(List<Integer> voti) {
		this.voti = voti;
	}*/

	public List<Recensione> getRecensioniFilm() {
		return recensioniFilm;
	}

	public void setRecensioniFilm(List<Recensione> recensioniFilm) {
		this.recensioniFilm = recensioniFilm;
	}

	public List<UtenteFilm> getUtenteFilm() {
		return utenteFilm;
	}

	public void setUtenteFilm(List<UtenteFilm> utenteFilm) {
		this.utenteFilm = utenteFilm;
	}
	
	
	
}
