package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="utentefilm", uniqueConstraints = @UniqueConstraint(columnNames = {"id_film", "id_utente"}))
public class UtenteFilm {
	
	@ManyToOne
    @JoinColumn(name="id_utente")
	private Utente uid;
	@ManyToOne
    @JoinColumn(name="id_film")
    private Film fid;
	
	@Column(nullable = false, columnDefinition="TINYINT DEFAULT 2")
    private Stato stato=Stato.da_vedere;
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    public UtenteFilm(){
    	
    }
    

	public UtenteFilm(Utente u_id, Film f_id, Stato stato) {
		this.id=id;
		this.uid = u_id;
		this.fid = f_id;
		this.stato = stato;
	}



	public UtenteFilm(Utente u_id, Film f_id) {
		this.uid = u_id;
		this.fid = f_id;
		this.id = id;
	}

	public Utente getU_id() {
		return uid;
	}

	public void setU_id(Utente u_id) {
		this.uid = u_id;
	}

	public Film getF_id() {
		return fid;
	}

	public void setF_id(Film f_id) {
		this.fid = f_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
	public Stato getStatoAttuale() {
        return stato;
    }
    public void setStatoAttuale(Stato stato) {
        this.stato = stato;
    }
    
}
