package com.example.demo.facadeImpl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.request.LoginDTO;
import com.example.demo.dto.request.RegistrazioneDTO;
import com.example.demo.dto.response.UtenteDTO;
import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.facade.UtenteFacade;
import com.example.demo.mapper.UtenteMapper;
import com.example.demo.model.Utente;
import com.example.demo.service.UtenteService;

@Service
public class UtenteFacadeImpl implements UtenteFacade{
	
	private final UtenteService utenteService;
	private final UtenteMapper utenteMapper;
	
	public UtenteFacadeImpl(UtenteService utenteService, UtenteMapper utenteMapper) {
		this.utenteService=utenteService;
		this.utenteMapper=utenteMapper;
	}

	/*@Override
	public UtenteDTO login(LoginDTO dto) throws DatiNonValidiException {
		Utente u=utenteService.login(dto.getEmail(), dto.getPassword());
		return utenteMapper.toDto(u);
		
	}*/
	@Override
	public Utente login(LoginDTO dto) throws DatiNonValidiException {
		Utente u=utenteService.login(dto.getEmail(), dto.getPassword());
		return u;
		
	}

	@Override
	public boolean Registrazione(RegistrazioneDTO dto) {
		Utente u=utenteMapper.toUtente(dto);
		return utenteService.registraUtente(u);
	}

	@Override
	public UtenteDTO getUtenteById(long id) {
		Utente u=utenteService.getUtenteById(id);
		return utenteMapper.toDto(u);
	}

	@Override
	public boolean rendiAdmin(long id) {
		return utenteService.rendiAdmin(id);
	}

	@Override
	public boolean bloccaUtente(long id) {
		return utenteService.bloccaUtente(id);
	}

	/*@Override
	public LoginDTO login(LoginDTO dto) {
		Utente u=UtenteService.login(dto.getEmail(),dto.getPassword());
		return utenteMapper.todto(u);
	}*/
	
	
	
	
	
	
	

}
