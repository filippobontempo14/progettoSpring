package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Ruolo {
	
	UTENTE("UTENTE"),
	ADMIN("ADMIN");
	
	private String nome;
	
	
}
