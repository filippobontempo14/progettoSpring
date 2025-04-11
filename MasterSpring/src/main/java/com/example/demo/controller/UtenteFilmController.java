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

import com.example.demo.dto.request.AggiornamentoStatoFilmDTO;
import com.example.demo.dto.response.FilmConStatoDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.service.UtenteFilmService;
import com.example.demo.service.UtenteService;

@RestController
@RequestMapping(value = "/UtenteFilm")
public class UtenteFilmController {
	
	private final UtenteFilmService utentefilmService;
	
	public UtenteFilmController(UtenteFilmService utentefilmService) {
		this.utentefilmService=utentefilmService;
	}
	
	@PostMapping("/user/aggiornaStatoFilm")
	public ResponseEntity<Boolean> aggiornaStatoFilm(@RequestBody AggiornamentoStatoFilmDTO a) throws DatiNonValidiException{
		boolean r=utentefilmService.aggiornaStatoFilm(a.getIdUtente(), a.getIdFilm(), a.getStato());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
		
	}
	
	@GetMapping("/user/getListaFilmConStato")
	public ResponseEntity<List<FilmConStatoDTO>> getListaFilmConStato(@RequestParam long idU){
		List<FilmConStatoDTO> lfs=utentefilmService.getListaFilmStato(idU);
		if(lfs!=null) return ResponseEntity.status(HttpStatus.ACCEPTED).body(lfs);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(lfs);
	}
	
	@PostMapping("/admin/addUtenteFilm")
	public ResponseEntity<Boolean> addUtenteFilm(@RequestParam long idU,@RequestParam long idF) throws DatiNonValidiException{
		boolean r=utentefilmService.addUtenteFilm(idU, idF);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
	}
}
