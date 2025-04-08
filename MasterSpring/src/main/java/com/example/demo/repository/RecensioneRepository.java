package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Recensione;

public interface RecensioneRepository extends JpaRepository<Recensione, Long>{

	//List<Recensione> findAllById_Utente(long id);
	
	List<Recensione> findAllByFilmId(long id);

	List<Recensione> findAllByUtenteId(long id);
	
	List<Recensione> findAllBySerieId(long id);

	
	/*@Query("select r from Recensione r where r.prezzo=:prezzo")
	Optional<Recensione> getRecensioneByPrezzo(double prezzo);
	
	@Query(nativeQuery=true, value="select * from recensione where voto<=:voto")
	List<Recensione> getRecensioneByVotoMax(int voto);*/
	
	//List<Recensione> findAllByAutore_Utente_IdAndAutore_Utente_BloccatoIsFalseOrederByTitoloDesc(long id);
}
