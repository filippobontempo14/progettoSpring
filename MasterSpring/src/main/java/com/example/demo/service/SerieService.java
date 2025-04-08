package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.response.SerieConTitoloDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.model.Serie;

public interface SerieService {
	
	public boolean addSerie(String titolo, int n_episodi, String genere) throws DatiNonValidiException;

	public List<Serie> getListaSerie();

	public Serie getSerieById(long id) throws DatiNonValidiException;

	public boolean bloccaSerie(long id) throws DatiNonValidiException;

	List<SerieConTitoloDTO> getListaSerieConTitolo();
}
