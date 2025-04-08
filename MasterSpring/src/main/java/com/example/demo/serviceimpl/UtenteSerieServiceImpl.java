package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.response.FilmConStatoDTO;
import com.example.demo.dto.response.SerieConStatoDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.model.Film;
import com.example.demo.model.Serie;
import com.example.demo.model.Stato;
import com.example.demo.model.Utente;
import com.example.demo.model.UtenteFilm;
import com.example.demo.model.UtenteSerie;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.SerieRepository;
import com.example.demo.repository.UtenteFilmRepository;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.repository.UtenteSerieRepository;
import com.example.demo.service.UtenteFilmService;
import com.example.demo.service.UtenteSerieService;

@Service
public class UtenteSerieServiceImpl implements UtenteSerieService{
	
	private final UtenteSerieRepository utenteserieRepo;
	private final UtenteRepository utenteRepo;
	private final SerieRepository serieRepo;
	
	public UtenteSerieServiceImpl(UtenteSerieRepository utenteserieRepo,UtenteRepository utenteRepo,SerieRepository serieRepo) {
		this.utenteserieRepo=utenteserieRepo;
		this.utenteRepo=utenteRepo;
		this.serieRepo=serieRepo;
	}
	
	@Override
	public boolean aggiornaStatoSerie(long idUtente, long idFilm, Stato stato) throws DatiNonValidiException{
		Utente u=utenteRepo.findById(idUtente).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'utente non esiste"));
		Serie s=serieRepo.findById(idFilm).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"La serie non esiste"));
		if(u==null||s==null||stato==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Dati inseriti non validi");
		UtenteSerie us=utenteserieRepo.findByUsid_idAndSid_id(idUtente, idFilm).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'utente o la serie non esistono"));
		
		us.setStatoAttuale(stato);
		utenteserieRepo.save(us);
		
		return true;
	}

	@Override
	public boolean addUtenteSerie(long idU, long idS) throws DatiNonValidiException{
		Utente u=utenteRepo.findById(idU).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'utente non esiste"));
		Serie s=serieRepo.findById(idS).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"La serie non esiste"));
		
		UtenteSerie us=new UtenteSerie(u,s,Stato.da_vedere);
		utenteserieRepo.save(us);
		u.getUtenteSerie().add(us);
		s.getUtenteserie().add(us);
		
		return true;
	}
	
	public List<SerieConStatoDTO> getListaSerieStato(long idU){
		List<UtenteSerie> us=utenteserieRepo.findAllByUsid_id(idU);
		List<SerieConStatoDTO> scs=new ArrayList<>();
		for(UtenteSerie u:us) {
			SerieConStatoDTO scs2=new SerieConStatoDTO(u.getSid().getTitolo(), u.getStatoAttuale());
			scs.add(scs2);
		}
		return scs;
	}

	
}
