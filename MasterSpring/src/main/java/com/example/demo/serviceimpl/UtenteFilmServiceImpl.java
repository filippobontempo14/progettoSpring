package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.request.AggiornamentoStatoFilmDTO;
import com.example.demo.dto.response.FilmConStatoDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.model.Film;
import com.example.demo.model.Stato;
import com.example.demo.model.Utente;
import com.example.demo.model.UtenteFilm;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.UtenteFilmRepository;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.service.UtenteFilmService;

@Service
public class UtenteFilmServiceImpl implements UtenteFilmService{
	
	private final UtenteFilmRepository utentefilmRepo;
	private final UtenteRepository utenteRepo;
	private final FilmRepository filmRepo;
	
	public UtenteFilmServiceImpl(UtenteFilmRepository utentefilmRepo,UtenteRepository utenteRepo,FilmRepository filmRepo) {
		this.utentefilmRepo=utentefilmRepo;
		this.utenteRepo=utenteRepo;
		this.filmRepo=filmRepo;
	}
	
	@Override
	public boolean aggiornaStatoFilm(long idUtente, long idFilm, Stato s) throws DatiNonValidiException{
		Utente u=utenteRepo.findById(idUtente).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'utente non esiste"));
		Film f=filmRepo.findById(idFilm).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Il film non esiste"));
		if(u==null||f==null||s==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Dati inseriti non validi");
		UtenteFilm uf=utentefilmRepo.findByUid_idAndFid_id(idUtente, idFilm).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'utente o il film non esistono"));
		
		uf.setStatoAttuale(s);
		utentefilmRepo.save(uf);
		
		return true;
	}

	@Override
	public boolean addUtenteFilm(long idU, long idF) throws DatiNonValidiException{
		Utente u=utenteRepo.findById(idU).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'utente non esiste"));
		Film f=filmRepo.findById(idF).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Il film non esiste"));
		
		UtenteFilm uf=new UtenteFilm(u,f,Stato.da_vedere);
		utentefilmRepo.save(uf);
		u.getUtenteFilm().add(uf);
		f.getUtenteFilm().add(uf);
		
		return true;
	}
	
	public List<FilmConStatoDTO> getListaFilmStato(long idU){
		List<UtenteFilm> uf=utentefilmRepo.findAllByUid_id(idU);
		List<FilmConStatoDTO> fcs=new ArrayList<>();
		for(UtenteFilm u:uf) {
			FilmConStatoDTO fcs2=new FilmConStatoDTO(u.getF_id().getTitolo(), u.getStatoAttuale());
			fcs.add(fcs2);
		}
		return fcs;
	}
	
	
}
