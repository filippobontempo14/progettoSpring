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

import com.example.demo.dto.request.AggiornamentoStatoSerieDTO;
import com.example.demo.dto.request.AggiornamentoStatoFilmDTO;
import com.example.demo.dto.response.FilmConStatoDTO;
import com.example.demo.dto.response.SerieConStatoDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.service.UtenteFilmService;
import com.example.demo.service.UtenteSerieService;

@RestController
@RequestMapping(value = "/UtenteSerie")
public class UtenteSerieController {
	
private final UtenteSerieService utenteserieService;
	
	public UtenteSerieController(UtenteSerieService utenteserieService) {
		this.utenteserieService=utenteserieService;
	}
	
	@PostMapping("/user/aggiornaStatoSerie")
	public ResponseEntity<Boolean> aggiornaStatoSerie(@RequestBody AggiornamentoStatoSerieDTO a) throws DatiNonValidiException{
		boolean r=utenteserieService.aggiornaStatoSerie(a.getIdUtente(), a.getIdSerie(), a.getStato());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
	}
	
	@GetMapping("/user/getListaSerieConStato")
	public ResponseEntity<List<SerieConStatoDTO>> getListaSerieConStato(@RequestParam long idU){
		List<SerieConStatoDTO> lfs=utenteserieService.getListaSerieStato(idU);
		if(lfs!=null) return ResponseEntity.status(HttpStatus.ACCEPTED).body(lfs);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(lfs);
	}
	
	@PostMapping("/admin/addUtenteSerie")
	public ResponseEntity<Boolean> addUtenteSerie(@RequestParam long idU,@RequestParam long idS) throws DatiNonValidiException{
		boolean r=utenteserieService.addUtenteSerie(idU, idS);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
	}
}
