package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.db.MioDB;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.model.Film;
import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.service.UtenteService;

@RestController
@RequestMapping(value = "/Utente")
public class UtenteController {
	
	private final UtenteService utenteService;
	
	public UtenteController(UtenteService utenteService) {
		this.utenteService=utenteService;
	}
	
	
	
	/*@PostMapping("/registra")	
	public ResponseEntity<Boolean> registraUtente(@RequestParam String nome,@RequestParam String email,@RequestParam LocalDate data,@RequestParam String password){
		boolean result;
		try {
			result = utenteService.registraUtente(nome, email, password, data);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
		} catch (DatiNonValidiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,e.getMessage());
		}
	}*/
	@PostMapping("/registra")
	public ResponseEntity<Boolean> registraUtente(@RequestParam String nome,@RequestParam String email,@RequestParam LocalDate data,@RequestParam String password) throws DatiNonValidiException{
		boolean result = utenteService.registraUtente(nome, email, password, data);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
	}
	
	@GetMapping("/login")	
	public ResponseEntity<Utente> loginUtente(@RequestParam String email,@RequestParam String password){
		try {
			Utente u=utenteService.login(email, password);
			return ResponseEntity.status(HttpStatus.OK).body(u);
		}catch(DatiNonValidiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,e.getMessage());
		}
	}
	
	@GetMapping("/getUtenteById")
	public ResponseEntity<Utente> getUtenteById(@RequestParam long id){
		try {
			Utente u=utenteService.getUtenteById(id);
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}catch(DatiNonValidiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,e.getMessage());
		}
	}
	
	/*@GetMapping("/getUtenteById")	
	public ResponseEntity<Utente> getUtenteById(@RequestParam long id){
		Utente u=MioDB.getInstance().getUtenteById(id);
		return ResponseEntity.ok().body(u);
	}*/
	
	@PostMapping("/admin")	
	public ResponseEntity<Boolean> rendiAdmin(@RequestParam long id){
		boolean r;
		try {
			r = utenteService.rendiAdmin(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
		} catch (DatiNonValidiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,e.getMessage());
		}
	}
	
	@PostMapping("/bloccato")	
	public ResponseEntity<Boolean> bloccaUtente(@RequestParam long id){
		boolean r;
		try {
			r = utenteService.bloccaUtente(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
		} catch (DatiNonValidiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,e.getMessage());
		}
	}
	
	
	

}
