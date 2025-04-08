package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.request.addFilmDTO;
import com.example.demo.dto.response.FilmConTitoloDTO;
import com.example.demo.dto.response.MediaFilmDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.exceptionHandler.customException.FilmNonValidoException;
import com.example.demo.model.Film;

public interface FilmService {
	
	public boolean addFilm(addFilmDTO a) throws DatiNonValidiException;
	public List<Film> getListaFilm();
	public Film getById(long id);
	public boolean bloccaFilm(long id) throws DatiNonValidiException;
	public List<MediaFilmDTO> getMediaFilm();
	List<FilmConTitoloDTO> getListaFilmConTitolo();
}
