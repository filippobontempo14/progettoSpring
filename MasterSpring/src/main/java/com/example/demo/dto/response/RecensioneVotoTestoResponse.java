package com.example.demo.dto.response;

public class RecensioneVotoTestoResponse {
	
	private String testo;
	private int voto;
	
	public RecensioneVotoTestoResponse() {
		
		
	}
	
	public RecensioneVotoTestoResponse(String testo, int voto) {
		
		this.testo = testo;
		this.voto = voto;
	}
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
	
	
}
