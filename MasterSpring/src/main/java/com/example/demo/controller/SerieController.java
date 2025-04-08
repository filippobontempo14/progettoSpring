package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.MioDB;
import com.example.demo.dto.request.SerieRequest;
import com.example.demo.dto.response.SerieConTitoloDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.model.Film;
import com.example.demo.model.Serie;
import com.example.demo.service.FilmService;
import com.example.demo.service.SerieService;

@RestController
@RequestMapping(value = "/Serie")
public class SerieController {
	
	private final SerieService serieService;
	
	public SerieController(SerieService serieService) {
		this.serieService=serieService;
	}
	
	@PostMapping("/addSerie")	
	public ResponseEntity<Boolean> addSerie(@RequestBody SerieRequest s) throws DatiNonValidiException{
		boolean r=serieService.addSerie(s.getTitolo(),s.getN_episodi(),s.getGenere());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
		
	}
	
	@GetMapping("/getListaSerie")	
	public ResponseEntity<List<Serie>> getListaSerie(){
		List<Serie> s=serieService.getListaSerie();
		if(s!=null) return ResponseEntity.status(HttpStatus.OK).body(s);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
	}
	
	@PostMapping("/bloccaSerie")	
	public ResponseEntity<Boolean> bloccaSerie(@RequestParam long id) throws DatiNonValidiException{
		boolean r=serieService.bloccaSerie(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();		
	}
	
	@GetMapping("/getSerieById")	
	public ResponseEntity<Serie> getSerieById(@RequestParam long id) throws DatiNonValidiException{
		Serie s=serieService.getSerieById(id);
		return ResponseEntity.status(HttpStatus.OK).body(s);
	}
	
	@GetMapping("/getListaSerieConTitolo")	
	public ResponseEntity<List<SerieConTitoloDTO>> getListaSerieDTO(){
		List<SerieConTitoloDTO> s=serieService.getListaSerieConTitolo();
		if(s!=null) return ResponseEntity.status(HttpStatus.OK).body(s);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
	}
}
