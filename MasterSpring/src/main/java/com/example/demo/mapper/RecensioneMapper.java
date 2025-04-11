package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.RecensioneFilmConIdDTO;
import com.example.demo.dto.response.RecensioneVotoTestoFilmSerieUtenteDTO;
import com.example.demo.dto.response.RecensioneVotoTestoResponse;
import com.example.demo.model.Recensione;

@Component
public class RecensioneMapper {

    private final UtenteMapper utenteMapper;
	
	
	FilmMapper filmMapper;
	SerieMapper serieMapper;
	
	
	public RecensioneMapper(FilmMapper filmMapper,SerieMapper serieMapper, UtenteMapper utenteMapper) {
		this.filmMapper = filmMapper;
		this.serieMapper = serieMapper;
		this.utenteMapper = utenteMapper;
	}

	public List<RecensioneVotoTestoResponse> toDto(List<Recensione> r) {
		List<RecensioneVotoTestoResponse> rvtLista=new ArrayList<>();
		for(Recensione r1:r) {
			RecensioneVotoTestoResponse rvt=new RecensioneVotoTestoResponse(r1.getTesto(),r1.getVoto());
			rvtLista.add(rvt);
		}
		return rvtLista;
	}
	
	public List<RecensioneVotoTestoFilmSerieUtenteDTO> toDtoCompleto(List<Recensione> r) {
		List<RecensioneVotoTestoFilmSerieUtenteDTO> recensioni=new ArrayList<>();
		for(Recensione r1:r) {
			RecensioneVotoTestoFilmSerieUtenteDTO rvtfu=new RecensioneVotoTestoFilmSerieUtenteDTO();
			//rvtfu.getFilm().setTitolo(r1.getFilm().getTitolo());
			if(r1.getFilm()!=null) {
				rvtfu.setFilm(filmMapper.toFilmTitolo(r1.getFilm()));
			}else {
				rvtfu.setSerie(serieMapper.toSerieTitolo(r1.getSerie()));
			}
			
			rvtfu.setTesto(r1.getTesto());
			rvtfu.setVoto(r1.getVoto());
			rvtfu.setId(r1.getId());
			recensioni.add(rvtfu);
		
		}
		return recensioni;
	}
	
	public RecensioneVotoTestoFilmSerieUtenteDTO toDtoSingolo(Recensione r) {
		RecensioneVotoTestoFilmSerieUtenteDTO recensione=new RecensioneVotoTestoFilmSerieUtenteDTO();
		
		if(r.getFilm()!=null) {
			recensione.setFilm(filmMapper.toFilmTitolo(r.getFilm()));
		}else {
			recensione.setSerie(serieMapper.toSerieTitolo(r.getSerie()));
		}
			
		recensione.setTesto(r.getTesto());
		recensione.setVoto(r.getVoto());
		recensione.setId(r.getId());
		
		return recensione;
	}
	
	public RecensioneFilmConIdDTO toDtoSingolo2(Recensione r) {
		RecensioneFilmConIdDTO recensione=new RecensioneFilmConIdDTO();
		
		
		recensione.setId_film(filmMapper.toFilmTitolo(r.getFilm()).getId());
		
			
		recensione.setTesto(r.getTesto());
		recensione.setVoto(r.getVoto());
		recensione.setId_utente(r.getUtente().getId());
		
		return recensione;
	}
}
