package com.example.demo.controller;


import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.MioDB;
import com.example.demo.model.Utente;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/endPoint1")
public class PrimoController {
	
	
	//@RequestMapping(method=RequestMethod.GET,value="/saluta")
	@GetMapping(value="/saluta")
	public String saluta() {
		return "Ciao";
	}
	
	@GetMapping(value="/metodo2/{nome}")
	public String saluta2(@PathVariable String nome) {
		return "Ciao " + nome;
	}
	
	@GetMapping(value="/metodo3", consumes = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String saluta3(@RequestParam String nome) {
		return "Ciao " + nome;
	}
	
	@PostMapping("/salutaUtente")	
	public ResponseEntity<Utente> salutaUtente(@RequestBody Utente u){
		if(u == null) {
			return null;
		}
		//return ResponseEntity.ok("Ciao "+u.getNome());
		
		return ResponseEntity.ok().body(u);
		//return ResponseEntity.ok().build();
	}
	
	@PostMapping("/user/registra")	
	public ResponseEntity<String> registraUtente(@RequestParam String nome,@RequestParam String email,@RequestParam LocalDate data,@RequestParam String password){
		MioDB.getInstance().registraUtente(nome, email, password, data);
		return ResponseEntity.ok().build();
	}

}









