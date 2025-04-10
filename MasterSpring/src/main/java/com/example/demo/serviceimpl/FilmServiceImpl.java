package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.request.addFilmDTO;
import com.example.demo.dto.response.FilmConStatoDTO;
import com.example.demo.dto.response.FilmConTitoloDTO;
import com.example.demo.dto.response.MediaFilmDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.exceptionHandler.customException.FilmNonValidoException;
import com.example.demo.mapper.FilmMapper;
import com.example.demo.model.Film;
import com.example.demo.model.Recensione;
import com.example.demo.model.Utente;
import com.example.demo.repository.FilmRepository;
import com.example.demo.service.FilmService;
import com.example.demo.service.UtenteService;

@Service
public class FilmServiceImpl implements FilmService{

	private final FilmRepository filmRepo;
	private final FilmMapper filmMapper;
	
	public FilmServiceImpl(FilmRepository filmRepo,FilmMapper filmMapper) {
		this.filmRepo=filmRepo;
		this.filmMapper=filmMapper;
	}
	
	public boolean addFilm(addFilmDTO a) throws DatiNonValidiException {
		if(a.getTitolo()==null||a.getDurata()<=0||a.getGenere()==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Film non valido");
		Film f=new Film(a.getTitolo(), a.getDurata(),a.getGenere());
		filmRepo.save(f);
		return true;
	}
	
	public List<Film> getListaFilm(){
		return filmRepo.findAll();
	}
	
	public Film getById(long id) {
		return filmRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Il film non esiste"));
	}

	public boolean bloccaFilm(long id) throws DatiNonValidiException{
		if(id<=0)return false;
		Film f=filmRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Il film non esiste"));
		if(f.isBloccato())f.setBloccato(false);
		else f.setBloccato(true);
		filmRepo.save(f);
		return true;
	}
	
	public double getMedia(Film f){
		
		double somma=0;
		double count=0;
		List <Recensione> r=f.getRecensioniFilm();
		for(Recensione r1:r) {
			somma=somma+r1.getVoto();
			count++;
		}
		double media=somma/count;
		return media;
	}
	
	public List<MediaFilmDTO> getMediaFilm(){
		List<Film> f=getListaFilm();
		List<MediaFilmDTO> mf=new ArrayList<>();
		for(Film f1:f) {
			
			MediaFilmDTO mediaFilm=new MediaFilmDTO(f1.getTitolo(), getMedia(f1));
			mf.add(mediaFilm);
			
		}
		return mf;
	}
	
	@Override
	public List<FilmConTitoloDTO> getListaFilmConTitolo(){
		List<Film> f=getListaFilm();
		return filmMapper.toDto(f);
	}

	
}
