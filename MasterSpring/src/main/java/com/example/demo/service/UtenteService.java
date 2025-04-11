package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.model.Utente;

public interface UtenteService {
	
	//boolean registraUtente(String nome,String email,String password,LocalDate data);
	Utente getUtenteById(long id);
	List<Utente> getAll();
	Utente getByData(LocalDate data);
	Utente login(String email, String password)throws DatiNonValidiException;
	boolean bloccaUtente(long id);
	boolean rendiAdmin(long id);
	boolean registraUtente(Utente u);
	Utente getByEmail(String a);
}
