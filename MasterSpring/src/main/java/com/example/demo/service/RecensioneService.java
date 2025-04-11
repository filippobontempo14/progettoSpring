package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.dto.response.RecensioneVotoTestoFilmSerieUtenteDTO;
import com.example.demo.dto.response.RecensioneVotoTestoResponse;
import com.example.demo.dto.response.TierListDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.model.Film;
import com.example.demo.model.Recensione;
import com.example.demo.model.Utente;

public interface RecensioneService {
	
	public boolean addRecensione(Recensione r);
	boolean addRecensioneSerie(int voto, String testo, long idUtente, long idSerie);
	
	Recensione getById(long id);
	List<Recensione> getAll();
	
	//List<Recensione> getRecensioniBySerie(long id);
	//public List<Recensione> getRecensioniByFilm(long id);
	List<Recensione> getRecensioniByUtente(long id);
	public RecensioneVotoTestoFilmSerieUtenteDTO modificaRecensione(long id, int voto, String testo);
	List<RecensioneVotoTestoFilmSerieUtenteDTO> getRecensioniVotoTestoByFilm(long id);
	List<RecensioneVotoTestoFilmSerieUtenteDTO> getRecensioniVotoTestoBySerie(long id);
	List<RecensioneVotoTestoFilmSerieUtenteDTO> getRecensioneVotoTestoFilmUtenteDTO(long id);
	
	List<TierListDTO> TierList(long idUtente);
	
	
	
	
}
