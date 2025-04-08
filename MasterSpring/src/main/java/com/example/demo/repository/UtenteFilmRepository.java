package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.response.FilmConStatoDTO;
import com.example.demo.model.Recensione;
import com.example.demo.model.UtenteFilm;

public interface UtenteFilmRepository extends JpaRepository<UtenteFilm, Long>{
	
	Optional<UtenteFilm> findByUid_idAndFid_id(long idUtente, long idFilm);
	
	/*@Query(nativeQuery=true, value="select utentefilm.id, utentefilm.id_utente, utentefilm.id_film from utentefilm left join film on utentefilm.id_film=film.id where id_utente=?")
	List<UtenteFilm> getListaUtenteFilm(long idUtente);*/
	
	/*@Query(nativeQuery=true, value="select film.titolo as titolo, utentefilm.stato as stato from film left join utentefilm on utentefilm.id_film=film.id and id_utente=:idUtente")*/
	List<UtenteFilm> findAllByUid_id(long idUtente);
}
