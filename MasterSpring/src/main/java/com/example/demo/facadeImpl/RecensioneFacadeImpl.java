package com.example.demo.facadeImpl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.request.RecensioneFilmConIdDTO;
import com.example.demo.facade.RecensioneFacade;
import com.example.demo.facade.UtenteFacade;
import com.example.demo.mapper.RecensioneMapper;
import com.example.demo.mapper.UtenteMapper;
import com.example.demo.model.Film;
import com.example.demo.model.Recensione;
import com.example.demo.model.Utente;
import com.example.demo.service.FilmService;
import com.example.demo.service.RecensioneService;
import com.example.demo.service.UtenteService;

@Service
public class RecensioneFacadeImpl implements RecensioneFacade{
	
	private final RecensioneService recensioneService;
	private final FilmService filmService;
	private final UtenteService utenteService;
	private final RecensioneMapper recensioneMapper;
	
	public RecensioneFacadeImpl(RecensioneService recensioneService, RecensioneMapper recensioneMapper, FilmService filmService, UtenteService utenteService) {
		this.recensioneService=recensioneService;
		this.recensioneMapper=recensioneMapper;
		this.filmService=filmService;
		this.utenteService=utenteService;
	}

	@Override
	public boolean addRecensione(RecensioneFilmConIdDTO r) {
		Utente u=utenteService.getUtenteById(r.getId_utente());
		Film f=filmService.getById(r.getId_film());
		if(r.getVoto()<=0||r.getTesto()==null||u==null||f==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Recensione non valida");
		Recensione a = new Recensione(r.getVoto(), r.getTesto(), u,f);
		return recensioneService.addRecensione(a);
	}

	
	
	
}
