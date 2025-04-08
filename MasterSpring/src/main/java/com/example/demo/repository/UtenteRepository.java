package com.example.demo.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long>{
	
	Optional<Utente> findByDataAndBloccatoIsFalse(LocalDate data);
	
	Optional<Utente> findByEmailAndPasswordAndBloccatoIsFalse(String email, String password);
	
	Optional<Utente> findByEmail(String email);
	
	
	
}
