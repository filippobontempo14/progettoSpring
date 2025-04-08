package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.response.FilmConStatoDTO;
import com.example.demo.dto.response.SerieConStatoDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.model.Stato;

public interface UtenteSerieService {
	
	boolean aggiornaStatoSerie(long idUtente, long idSerie, Stato s) throws DatiNonValidiException;

	boolean addUtenteSerie(long idU, long idS) throws DatiNonValidiException;
	
	List<SerieConStatoDTO> getListaSerieStato(long idU);
}
