package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.response.SerieConTitoloDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.mapper.SerieMapper;
import com.example.demo.model.Film;
import com.example.demo.model.Serie;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.SerieRepository;
import com.example.demo.service.SerieService;

@Service
public class SerieServiceImpl implements SerieService{

private final SerieRepository serieRepo;
private final SerieMapper serieMapper;
	
	public SerieServiceImpl(SerieRepository serieRepo,SerieMapper serieMapper) {
		this.serieRepo=serieRepo;
		this.serieMapper=serieMapper;
	}
	
	@Override
	public boolean addSerie(String titolo, int n_episodi, String genere) throws DatiNonValidiException{
		if(titolo==null||n_episodi<=0||genere==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Serie non valida");
		Serie s=new Serie(titolo, n_episodi, genere);
		serieRepo.save(s);
		return true;
	}
	@Override
	public List<Serie> getListaSerie(){
		return serieRepo.findAll();
	}
	@Override
	public Serie getSerieById(long id) throws DatiNonValidiException{
		return serieRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"La serie non esiste"));
	}
	@Override
	public boolean bloccaSerie(long id) throws DatiNonValidiException{
		if(id<=0)return false;
		Serie s=serieRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"La serie non esiste"));
		if(s.isBloccato())s.setBloccato(false);
		else s.setBloccato(true);
		serieRepo.save(s);
		return true;
	}
	
	@Override
	public List<SerieConTitoloDTO> getListaSerieConTitolo(){
		List<Serie> s=getListaSerie();
		return serieMapper.toDto(s);
	}
	
}
