package com.example.demo.dto.response;

public class MediaFilmDTO {
	
	private String titolo;
	private double mediaVoti;
	
	
	public MediaFilmDTO() {
		
	}

	public MediaFilmDTO( String titolo,double mediaVoti) {
	
		this.titolo = titolo;
		this.mediaVoti = mediaVoti;
	}

	public double getMediaVoti() {
		return mediaVoti;
	}

	public void setMediaVoti(double mediaVoti) {
		this.mediaVoti = mediaVoti;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	
	
}
