package com.example.demo.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.exceptionHandler.customException.DatiNonValidiException;
import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.service.UtenteService;

@Service
public class UtenteServiceImpl implements UtenteService{

	private final UtenteRepository utenteRepo;
	
	public UtenteServiceImpl(UtenteRepository utenteRepo) {
		this.utenteRepo=utenteRepo;
	}
	
	@Override
	public boolean registraUtente(String nome, String email, String password, LocalDate data) throws DatiNonValidiException {
		if(nome==null||email==null||password==null||data==null)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'email o la password non sono validi");
		if(utenteRepo.findByEmail(email).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'email o la password sono gia presenti");
		}else {
			Utente u=new Utente(nome, data, email, password);
			utenteRepo.save(u);
			return true;
		}
		
	}

	@Override
	public Utente getUtenteById(long id) throws DatiNonValidiException {
		return utenteRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'id non è valido"));
	}

	@Override
	public List<Utente> getAll() {
		return utenteRepo.findAll();
	}

	@Override
	public Utente getByData(LocalDate data) {
		return utenteRepo.findByDataAndBloccatoIsFalse(data).orElse(null);
	}
	
	@Override
	public Utente login(String email, String password) throws DatiNonValidiException {
		if(email==null||password==null/*||password.length()<8*/) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'email o la password non sono validi");
		return utenteRepo.findByEmailAndPasswordAndBloccatoIsFalse(email, password).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'email o la password sono errati"));
	}
	
	@Override
	public boolean bloccaUtente(long id) throws DatiNonValidiException{
		if(id<=0)return false;
		Utente u=utenteRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'id non è valido"));
		if(u.isBloccato())u.setBloccato(false);
		else u.setBloccato(true);
		utenteRepo.save(u);
		return true;
	}
	
	@Override
	public boolean rendiAdmin(long id) throws DatiNonValidiException{
		if(id<=0)return false;
		Utente u=utenteRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'id non è valido"));
		if(u.isAdmin())u.setAdmin(false);
		else u.setAdmin(true);
		utenteRepo.save(u);
		return true;
	}
	
}
