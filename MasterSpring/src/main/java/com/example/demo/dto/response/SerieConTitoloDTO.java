package com.example.demo.dto.response;

public class SerieConTitoloDTO {
	
	private String titolo;
	private long id;

	public SerieConTitoloDTO(String titolo,long id) {
		
		this.titolo = titolo;
		this.id=id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
