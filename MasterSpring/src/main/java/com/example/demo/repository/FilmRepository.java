package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.response.MediaFilmDTO;
import com.example.demo.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long>{
	
	@Query(nativeQuery=true, value="SELECT titolo,AVG(voto) AS mediaVoti FROM film JOIN recensione ON film.id=id_film GROUP BY film.id ORDER BY mediaVoti DESC LIMIT 10")
	List<Film> mediaPerFilm();
	
}
