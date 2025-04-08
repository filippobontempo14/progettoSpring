package com.example.demo.dto.request;

public class RecensioneFilmConIdDTO {
	
	
	private String testo;
	private int voto;
	private long id_film;
	private long id_utente;
	
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public long getId_film() {
		return id_film;
	}
	public void setId_film(long id_film) {
		this.id_film = id_film;
	}
	public long getId_utente() {
		return id_utente;
	}
	public void setId_utente(long id_utente) {
		this.id_utente = id_utente;
	}
	
	
}
