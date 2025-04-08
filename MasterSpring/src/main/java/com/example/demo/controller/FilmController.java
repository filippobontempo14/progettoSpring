package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.db.MioDB;
import com.example.demo.dto.request.addFilmDTO;
import com.example.demo.dto.response.FilmConTitoloDTO;
import com.example.demo.dto.response.MediaFilmDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.exceptionHandler.customException.FilmNonValidoException;
import com.example.demo.model.Film;
import com.example.demo.model.Utente;
import com.example.demo.repository.FilmRepository;
import com.example.demo.service.FilmService;

@RestController
@RequestMapping(value = "/Film")
public class FilmController {
	
	private final FilmService filmService;
	
	public FilmController(FilmService filmService) {
		this.filmService=filmService;
	}
	
	
	@PostMapping("/addFilm")	
	public ResponseEntity<Boolean> addFilm(@RequestBody addFilmDTO a) throws DatiNonValidiException{
		boolean r = filmService.addFilm(a);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@GetMapping("/getListaFilm")	
	public ResponseEntity<List<Film>> getListaFilm(){
		List<Film> f=filmService.getListaFilm();
		if(f!=null) return ResponseEntity.status(HttpStatus.OK).body(f);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
	}
	
	@PostMapping("/bloccaFilm")	
	public ResponseEntity<Boolean> bloccaFilm(@RequestParam long id) throws DatiNonValidiException{
		boolean r = filmService.bloccaFilm(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
	}
	
	@GetMapping("/getFilmById")	
	public ResponseEntity<Film> getFilmById(@RequestParam long id) throws DatiNonValidiException{
		Film f=filmService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(f);
	}
	
	@GetMapping("/getMedia")	
	public ResponseEntity<List<MediaFilmDTO>> getMediaFilm(){
		List<MediaFilmDTO> m=filmService.getMediaFilm();
		if(m!=null) return ResponseEntity.status(HttpStatus.OK).body(m);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
	}
	
	@GetMapping("/getListaFilmConTitolo")	
	public ResponseEntity<List<FilmConTitoloDTO>> getListaFilmConTitolo(){
		List<FilmConTitoloDTO> m=filmService.getListaFilmConTitolo();
		if(m!=null) return ResponseEntity.status(HttpStatus.OK).body(m);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
	}
	
	
}
