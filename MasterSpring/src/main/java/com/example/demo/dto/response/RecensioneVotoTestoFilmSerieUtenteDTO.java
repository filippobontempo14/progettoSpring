package com.example.demo.dto.response;

public class RecensioneVotoTestoFilmSerieUtenteDTO {
	
	private long id;
	private String testo;
	private int voto;
	private FilmConTitoloDTO film;
	private SerieConTitoloDTO serie;
	private UtenteConEmailDTO utente;
	
	public RecensioneVotoTestoFilmSerieUtenteDTO(String testo, int voto, FilmConTitoloDTO film, UtenteConEmailDTO utente) {
		
		this.testo = testo;
		this.voto = voto;
		this.film = film;
		
		
	}
	

	public RecensioneVotoTestoFilmSerieUtenteDTO() {
		
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public FilmConTitoloDTO getFilm() {
		return film;
	}

	public void setFilm(FilmConTitoloDTO film) {
		this.film = film;
	}

	public SerieConTitoloDTO getSerie() {
		return serie;
	}

	public void setSerie(SerieConTitoloDTO serie) {
		this.serie = serie;
	}

	
	
}
