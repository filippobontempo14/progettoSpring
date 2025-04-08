package com.example.demo.dto.request;

import com.example.demo.model.Stato;

public class AggiornamentoStatoFilmDTO {
	
	private long idUtente;
	private long idFilm;
	private Stato stato;
	
	public long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}
	public long getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(long idFilm) {
		this.idFilm = idFilm;
	}
	public Stato getStato() {
		return stato;
	}
	public void setStato(Stato stato) {
		this.stato = stato;
	}
	
	
}
