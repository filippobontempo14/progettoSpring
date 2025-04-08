package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="utenteserie", uniqueConstraints = @UniqueConstraint(columnNames = {"id_serie", "id_utente"}))
public class UtenteSerie {
	
	@ManyToOne
    @JoinColumn(name="id_utente")
	private Utente usid;
	@ManyToOne
    @JoinColumn(name="id_serie")
    private Serie sid;
	
	
    
	@Column(nullable = false, columnDefinition="TINYINT DEFAULT 2")
    private Stato stato=Stato.da_vedere;
	
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	
    public UtenteSerie(){
    	
    }
    

	public UtenteSerie(Utente usid, Serie sid, Stato stato) {
		this.id=id;
		this.usid = usid;
		this.sid = sid;
		this.stato = stato;
	}



	public UtenteSerie(Utente usid, Serie sid) {
		this.sid = sid;
		this.usid = usid;
		this.id = id;
	}

	public Utente getUsid() {
		return usid;
	}


	public void setUsid(Utente usid) {
		this.usid = usid;
	}


	public Serie getSid() {
		return sid;
	}


	public void setSid(Serie sid) {
		this.sid = sid;
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
