package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.controller.FilmController;
import com.example.demo.dto.response.RecensioneVotoTestoFilmSerieUtenteDTO;
import com.example.demo.dto.response.RecensioneVotoTestoResponse;
import com.example.demo.dto.response.TierListDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.mapper.RecensioneMapper;
import com.example.demo.model.Film;
import com.example.demo.model.Recensione;
import com.example.demo.model.Serie;
import com.example.demo.model.Utente;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.RecensioneRepository;
import com.example.demo.repository.SerieRepository;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.service.RecensioneService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RecensioneServiceImpl implements RecensioneService{


	private final RecensioneRepository recensioneRepo;
	private final UtenteRepository utenteRepo;
	private final FilmRepository filmRepo;
	private final SerieRepository serieRepo;
	private final RecensioneMapper recensioneMapper;
	
	public RecensioneServiceImpl(RecensioneRepository recensioneRepo,UtenteRepository utenteRepo, FilmRepository filmRepo,SerieRepository serieRepo,RecensioneMapper recensioneMapper) {
		this.recensioneRepo=recensioneRepo;
		this.utenteRepo=utenteRepo;
		this.filmRepo = filmRepo;
		this.serieRepo=serieRepo;
		this.recensioneMapper=recensioneMapper;
		
	}
	
	@Override
	public boolean addRecensione(int voto, String testo, long idUtente, long idFilm) throws DatiNonValidiException{
		Utente u=utenteRepo.findById(idUtente).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'utente non esiste"));
		Film f=filmRepo.findById(idFilm).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Il film non esiste"));
		if(voto<=0||testo==null||u==null||f==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Recensione non valida");
		Recensione a = new Recensione(voto, testo, u,f);
		recensioneRepo.save(a);
		return true;
	}
	
	@Override
	public boolean addRecensioneSerie(int voto, String testo, long idUtente, long idSerie) {
		Utente u=utenteRepo.findById(idUtente).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'utente non esiste"));
		Serie s=serieRepo.findById(idSerie).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"La serie non esiste"));
		if(voto<=0||testo==null||u==null||s==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Recensione non valida");
		Recensione a = new Recensione(voto, testo, u,s);
		recensioneRepo.save(a);
		return true;
	}
	

	@Override
	public Recensione getById(long id) {
		return recensioneRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"La recensione non esiste"));
	}

	@Override
	public List<Recensione> getAll() {
		return recensioneRepo.findAll();
	}

	/*@Override
	public List<Recensione> getRecensioniByFilm(long id) {
		List<Recensione> r=recensioneRepo.findAllByFilmId(id);
		return r;
	}
	@Override
	public List<Recensione> getRecensioniBySerie(long id) {
		List<Recensione> r=recensioneRepo.findAllBySerieId(id);
		return r;
	}*/
	@Override
	public List<Recensione> getRecensioniByUtente(long id) {
		return recensioneRepo.findAllByUtenteId(id);
	}
	
	/*@Override
	public List<RecensioneVotoTestoResponse> getRecensioniVotoTestoByFilm(long id) {
		List<Recensione> r=recensioneRepo.findAllByFilmId(id);
		return recensioneMapper.toDto(r);
	}*/
	@Override
	public List<RecensioneVotoTestoFilmSerieUtenteDTO> getRecensioniVotoTestoByFilm(long id) {
		List<Recensione> r=recensioneRepo.findAllByFilmId(id);
		return recensioneMapper.toDtoCompleto(r);
	}
	
	/*@Override
	public List<RecensioneVotoTestoResponse> getRecensioniVotoTestoBySerie(long id) {
		List<Recensione> r=recensioneRepo.findAllBySerieId(id);
		return recensioneMapper.toDto(r);
	}*/
	public List<RecensioneVotoTestoFilmSerieUtenteDTO> getRecensioniVotoTestoBySerie(long id) {
		List<Recensione> r=recensioneRepo.findAllBySerieId(id);
		return recensioneMapper.toDtoCompleto(r);
	}
	
	@Override
	public List<RecensioneVotoTestoFilmSerieUtenteDTO> getRecensioneVotoTestoFilmUtenteDTO(long id) {
		List<Recensione> r=recensioneRepo.findAllByUtenteId(id);
		return recensioneMapper.toDtoCompleto(r);
	}
	
	
	@Override
	public RecensioneVotoTestoFilmSerieUtenteDTO modificaRecensione(long id,int voto, String testo) {
		if(voto<=0||testo==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Voto o testo non validi");
		Recensione r=recensioneRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"La recensione non esiste"));
		r.setVoto(voto);
		r.setTesto(testo);
		Recensione agg=recensioneRepo.save(r);
		return recensioneMapper.toDtoSingolo(agg);
		
	}
	
	@Override
	public List<TierListDTO> TierList(long idUtente){
		List<Recensione> r=getRecensioniByUtente(idUtente);
		
		List<TierListDTO> titoli=new ArrayList<>();
		TierListDTO trl=new TierListDTO();
		for(Recensione r1:r) {
			switch(r1.getVoto()) {
				case 5:
					if(r1.getFilm()!=null) {
						trl.getS().add(r1.getFilm().getTitolo());
						break;
					}else {
						trl.getS().add(r1.getSerie().getTitolo());
						break;
					}
				case 4:
					if(r1.getFilm()!=null) {
						trl.getA().add(r1.getFilm().getTitolo());
						break;
					}else {
						trl.getA().add(r1.getSerie().getTitolo());
						break;
					}
				case 3:
					if(r1.getFilm()!=null) {
						trl.getB().add(r1.getFilm().getTitolo());
						break;
					}else {
						trl.getS().add(r1.getSerie().getTitolo());
						break;
					}
				case 2:
					if(r1.getFilm()!=null) {
						trl.getC().add(r1.getFilm().getTitolo());
						break;
					}else {
						trl.getC().add(r1.getSerie().getTitolo());
						break;
					}
				case 1:
					if(r1.getFilm()!=null) {
						trl.getD().add(r1.getFilm().getTitolo());
						break;
					}else {
						trl.getD().add(r1.getSerie().getTitolo());
						break;
					}
				default:
					return null;
			}
			
		}
		titoli.add(trl);
		return titoli;
	}
	
	
	
	
	
}
