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
import com.example.demo.dto.request.RecensioneFilmConIdDTO;
import com.example.demo.dto.request.RecensioneSerieConIdDTO;
import com.example.demo.dto.response.RecensioneVotoTestoFilmSerieUtenteDTO;
import com.example.demo.dto.response.RecensioneVotoTestoResponse;
import com.example.demo.dto.response.TierListDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.facade.RecensioneFacade;
import com.example.demo.model.Film;
import com.example.demo.model.Recensione;
import com.example.demo.model.Utente;
import com.example.demo.service.RecensioneService;

@RestController
@RequestMapping(value = "/Recensione")
public class RecensioneController {
	
	private final RecensioneService recensioneService;
	
	/*public RecensioneController(RecensioneService recensioneService) {
		this.recensioneService=recensioneService;
	}*/
	private final RecensioneFacade recensioneFacade;
	
	public RecensioneController(RecensioneFacade recensioneFacade, RecensioneService recensioneService) {
		this.recensioneFacade=recensioneFacade;
		this.recensioneService=recensioneService;
	}
	
	
	/*@PostMapping("/addRecensione")	
	public ResponseEntity<String> addRecensione(@RequestBody RecensioneFilmConIdRequest r ){
		Utente u=MioDB.getInstance().getUtenteById(r.getId_utente());
		Film f=MioDB.getInstance().getFilmById(r.getId_film());
		MioDB.getInstance().addRecensioneFilm(r.getVoto(), r.getTesto(), u, f);
		return ResponseEntity.ok().build();
	}*/
	
	@PostMapping("/user/addRecensione")	
	public ResponseEntity<Boolean> addRecensione(@RequestBody RecensioneFilmConIdDTO r ) {
		boolean result=recensioneFacade.addRecensione(r);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
	}
	
	@PostMapping("/user/addRecensioneSerie")	
	public ResponseEntity<Void> addRecensioneSerie(@RequestBody RecensioneSerieConIdDTO r ) {
		boolean result=recensioneService.addRecensioneSerie(r.getVoto(),r.getTesto(), r.getId_utente(),r.getId_serie());
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	
	/*@GetMapping("/getRecensioneByFilm")	
	public ResponseEntity<List<Recensione>> getRecensioneByFilm(@RequestParam long id){
		List<Recensione> r = recensioneService.getRecensioniByFilm(id);
		if(r!=null) return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}*/
	@GetMapping("/user/getRecensioneVotoTestoByFilm")	
	public ResponseEntity<List<RecensioneVotoTestoFilmSerieUtenteDTO>> getRecensioniVotoTestoByFilm(@RequestParam long id){
		List<RecensioneVotoTestoFilmSerieUtenteDTO> r = recensioneService.getRecensioniVotoTestoByFilm(id);
		if(r!=null) return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
	@GetMapping("/admin/getRecensioneByUtente")	
	public ResponseEntity<List<Recensione>> getRecensioneByUtente(@RequestParam long id){
		List<Recensione> r = recensioneService.getRecensioniByUtente(id);
		if(r!=null) return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("/user/aggiornaRecensioneFilm")
	public ResponseEntity<RecensioneVotoTestoFilmSerieUtenteDTO> aggiornaRecensioneFilm(@RequestParam long id, @RequestParam int voto, @RequestParam String testo){
		RecensioneVotoTestoFilmSerieUtenteDTO r=recensioneService.modificaRecensione(id, voto, testo);
		if(r!=null) return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/user/TierList")
	public ResponseEntity<List<TierListDTO>> TierList(@RequestParam long idUtente){
		List<TierListDTO> tot = recensioneService.TierList(idUtente);
		if(tot!=null) return ResponseEntity.status(HttpStatus.ACCEPTED).body(tot);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();	
	}
	
	@GetMapping("/getRecensioneVotoTestoFilmSerieUtenteDTO")
	public ResponseEntity<List<RecensioneVotoTestoFilmSerieUtenteDTO>> getRecensioneVotoTestoFilmUtenteDTO(@RequestParam long id){
		List<RecensioneVotoTestoFilmSerieUtenteDTO> r = recensioneService.getRecensioneVotoTestoFilmUtenteDTO(id);
		if(r!=null) return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
}
