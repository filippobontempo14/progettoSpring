package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Recensione {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private int voto;
    private String testo;
    @ManyToOne
    @JoinColumn(name="id_film")
    private Film film;
    @ManyToOne
    @JoinColumn(name="id_serie")
    private Serie serie;
    @ManyToOne
    @JoinColumn(name="id_utente")
    private Utente utente;
    

    public Recensione() {

    }
    
    

	public Recensione(int voto, String testo) {
		
		this.id = id;
		this.voto = voto;
		this.testo = testo;
	}



	public Recensione(Film film/*, Serie serie*/, Utente utente, int voto, String testo) {

        this.id = id;
        this.film = film;
        //this.serie = serie;
        this.utente = utente;
        this.voto = voto;
        this.testo = testo;
    }

    public Recensione( int voto,String testo, Utente utente/*, Serie serie*/) {
        this.id = id;
        //this.serie = serie;
        this.utente = utente;
        this.voto = voto;
        this.testo = testo;
    }

    public Recensione( int voto, String testo, Utente utente, Film film) {
        this.id = id;
        this.film = film;
        this.utente = utente;
        this.voto = voto;
        this.testo = testo;
    }

    public Recensione(int voto, String testo, Utente utente, Serie serie) {
    	this.id = id;
        this.serie = serie;
        this.utente = utente;
        this.voto = voto;
        this.testo = testo;
	}



	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Utente getUtente() {

        return utente;
    }

    public void setUtente(Utente utente) {

        this.utente = utente;
    }

}
