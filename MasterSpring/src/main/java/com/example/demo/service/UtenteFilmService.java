package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.request.AggiornamentoStatoFilmDTO;
import com.example.demo.dto.response.FilmConStatoDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.model.Film;
import com.example.demo.model.Stato;
import com.example.demo.model.Utente;
import com.example.demo.model.UtenteFilm;

public interface UtenteFilmService {
	
	boolean aggiornaStatoFilm(long idUtente, long idFilm, Stato s) throws DatiNonValidiException;

	boolean addUtenteFilm(long idU, long idF) throws DatiNonValidiException;
	
	List<FilmConStatoDTO> getListaFilmStato(long idU);
	
	//public List<FilmConStato> getFilmConStato(long idU);	
}
