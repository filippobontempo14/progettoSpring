package com.example.demo.facade;

import com.example.demo.dto.request.LoginDTO;
import com.example.demo.dto.request.RegistrazioneDTO;
import com.example.demo.dto.response.UtenteDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.model.Utente;
import com.example.demo.service.UtenteService;

public interface UtenteFacade {
	
	
	//boolean noleggiaLibro(NoleggiaLibroDTO dto);
	Utente login(LoginDTO dto) throws DatiNonValidiException;
	boolean Registrazione(RegistrazioneDTO dto);
	UtenteDTO getUtenteById(long id);
	boolean rendiAdmin(long id);
	boolean bloccaUtente(long id);
}
