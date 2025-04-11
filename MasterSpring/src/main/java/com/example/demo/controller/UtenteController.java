package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.db.MioDB;
import com.example.demo.dto.request.LoginDTO;
import com.example.demo.dto.request.RegistrazioneDTO;
import com.example.demo.dto.response.UtenteDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.facade.UtenteFacade;
import com.example.demo.model.Film;
import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.security.GestoreToken;
import com.example.demo.service.UtenteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

public class UtenteController {
	
	private final UtenteFacade utenteFacade;
	private final GestoreToken gestore;
	
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
	@PostMapping("/all/registra")
	public ResponseEntity<Boolean> registraUtente(@Valid @RequestBody RegistrazioneDTO r) throws DatiNonValidiException{
		boolean result = utenteFacade.Registrazione(r);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
	}
	
	/*@GetMapping("/login")	
	public ResponseEntity<Utente> loginUtente(@RequestParam String email,@RequestParam String password){
		try {
			Utente u=utenteService.login(email, password);
			return ResponseEntity.status(HttpStatus.OK).body(u);
		}catch(DatiNonValidiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,e.getMessage());
		}
	}
	@GetMapping("/login")	
	public ResponseEntity<Utente> loginUtente(@Valid @RequestBody LoginDTO logindto ){
		try {
			Utente u=utenteService.login(logindto.getEmail(),logindto.getPassword());
			return ResponseEntity.status(HttpStatus.OK).body(u);
		}catch(DatiNonValidiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,e.getMessage());
		}
	}*/
	@PostMapping("/all/login")	
	public ResponseEntity<String> loginUtente(@Valid @RequestBody LoginDTO logindto) throws DatiNonValidiException{
		//UtenteDTO u=utenteFacade.login(logindto);
		Utente u=utenteFacade.login(logindto);
		//return ResponseEntity.status(HttpStatus.OK).body(u);
		return ResponseEntity.status(HttpStatus.OK).header("Authorization", gestore.generaToken(u)).build();
	}
	
	
	
	@GetMapping("/admin/getUtenteById")
	public ResponseEntity<UtenteDTO> getUtenteById(@RequestParam long id){
		UtenteDTO u=utenteFacade.getUtenteById(id);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(u);
	}
	
	/*@GetMapping("/getUtenteById")	
	public ResponseEntity<Utente> getUtenteById(@RequestParam long id){
		Utente u=MioDB.getInstance().getUtenteById(id);
		return ResponseEntity.ok().body(u);
	}*/
	
	@PostMapping("/admin/rendiAdmin")	
	public ResponseEntity<Boolean> rendiAdmin(@RequestParam long id){
		boolean r = utenteFacade.rendiAdmin(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
	}
	
	@PostMapping("/admin/bloccato")	
	public ResponseEntity<Boolean> bloccaUtente(@RequestParam long id){
		boolean r = utenteFacade.bloccaUtente(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
		
	}
	
	
	

}
