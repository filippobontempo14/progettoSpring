package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.response.FilmConTitoloDTO;
import com.example.demo.model.Film;

@Component
public class FilmMapper {
	public List<FilmConTitoloDTO> toDto(List<Film> f) {
		List<FilmConTitoloDTO> lft=new ArrayList<>();
		for(Film f1:f) {
			FilmConTitoloDTO film=new FilmConTitoloDTO(f1.getTitolo(),f1.getId());
			lft.add(film);
		}
		return lft;
	}
	
	public FilmConTitoloDTO toFilmTitolo(Film f) {
		FilmConTitoloDTO fct=new FilmConTitoloDTO(f.getTitolo(), f.getId());
		return fct;
		
	}
}
