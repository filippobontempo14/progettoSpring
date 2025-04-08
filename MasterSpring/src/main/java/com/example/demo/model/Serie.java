package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Serie {
	
	private String titolo;
	private int n_episodi;
	private String genere;
	private boolean bloccato;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToMany
	(mappedBy = "serie",fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	private List<Recensione> recensioniSerie = new ArrayList<>();
	//private List<Integer> voti = new ArrayList<>();
	@OneToMany
	(mappedBy = "sid", cascade=CascadeType.MERGE)
	private List<UtenteSerie> utenteserie = new ArrayList<>();
	
	public Serie() {
		
	}
	
	

	public Serie(String titolo, int n_episodi, String genere) {
		
		this.titolo = titolo;
		this.n_episodi = n_episodi;
		this.genere = genere;
		this.id = id;
	}



	public Serie(String titolo, int n_episodi, String genere, boolean bloccato) {

		this.titolo = titolo;
		this.n_episodi = n_episodi;
		this.genere = genere;
		this.bloccato = bloccato;
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getN_episodi() {
		return n_episodi;
	}

	public void setN_episodi(int n_episodi) {
		this.n_episodi = n_episodi;
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



	public List<Recensione> getRecensioniSerie() {
		return recensioniSerie;
	}



	public void setRecensioniSerie(List<Recensione> recensioniSerie) {
		this.recensioniSerie = recensioniSerie;
	}



	public List<UtenteSerie> getUtenteserie() {
		return utenteserie;
	}



	public void setUtenteserie(List<UtenteSerie> utenteserie) {
		this.utenteserie = utenteserie;
	}
	
	

}
