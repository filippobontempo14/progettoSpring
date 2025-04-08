package com.example.demo.dto.request;

import com.example.demo.model.Stato;

public class AggiornamentoStatoSerieDTO {
	
	private long idUtente;
	private long idSerie;
	private Stato stato;
	
	public long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}
	public long getIdSerie() {
		return idSerie;
	}
	public void setIdSerie(long idSerie) {
		this.idSerie = idSerie;
	}
	public Stato getStato() {
		return stato;
	}
	public void setStato(Stato stato) {
		this.stato = stato;
	}
}
