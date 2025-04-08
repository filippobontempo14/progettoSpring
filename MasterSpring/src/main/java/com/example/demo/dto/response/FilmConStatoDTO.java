package com.example.demo.dto.response;

import com.example.demo.model.Stato;

public class FilmConStatoDTO {
	
	private String titolo;
	private Stato stato;
	
	
	public FilmConStatoDTO(String titolo, Stato stato) {
		
		this.titolo = titolo;
		this.stato = stato;
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Stato getStato() {
		return stato;
	}
	public void setStato(Stato stato) {
		this.stato = stato;
	}
	
	
}
