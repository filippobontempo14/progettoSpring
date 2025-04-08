package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UtenteFilm;
import com.example.demo.model.UtenteSerie;

public interface UtenteSerieRepository extends JpaRepository<UtenteSerie, Long>{
	
	Optional<UtenteSerie> findByUsid_idAndSid_id(long idUtente, long idSerie);
	
	List<UtenteSerie> findAllByUsid_id(long idUtente);
}
