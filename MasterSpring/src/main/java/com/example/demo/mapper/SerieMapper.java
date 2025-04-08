package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.response.FilmConTitoloDTO;
import com.example.demo.dto.response.SerieConTitoloDTO;
import com.example.demo.model.Film;
import com.example.demo.model.Serie;

@Component
public class SerieMapper {
	
	public List<SerieConTitoloDTO> toDto(List<Serie> s) {
		List<SerieConTitoloDTO> lst=new ArrayList<>();
		for(Serie s1:s) {
			SerieConTitoloDTO serie=new SerieConTitoloDTO(s1.getTitolo(),s1.getId());
			lst.add(serie);
		}
		return lst;
	}
	
	public SerieConTitoloDTO toSerieTitolo(Serie s) {
		SerieConTitoloDTO sct=new SerieConTitoloDTO(s.getTitolo(), s.getId());
		return sct;	
	}
}
