package com.example.demo.dto.request;

public class RecensioneSerieConIdDTO {
	
	private String testo;
	private int voto;
	private long id_serie;
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
	public long getId_serie() {
		return id_serie;
	}
	public void setId_film(long id_serie) {
		this.id_serie = id_serie;
	}
	public long getId_utente() {
		return id_utente;
	}
	public void setId_utente(long id_utente) {
		this.id_utente = id_utente;
	}
}
