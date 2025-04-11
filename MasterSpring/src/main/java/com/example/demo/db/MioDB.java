package com.example.demo.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.request.RecensioneFilmConIdDTO;
import com.example.demo.model.Film;
import com.example.demo.model.Recensione;
import com.example.demo.model.Serie;
import com.example.demo.model.Utente;

public final class MioDB {
	
	private static final MioDB instance=new MioDB();
	
	private MioDB() {
		
	}
	
	public static MioDB getInstance() {
		return instance;
	}
	
	
	private List<Utente> utenti=new ArrayList<>();
	private List<Film> film=new ArrayList<>();
	private List<Serie> serie=new ArrayList<>();
	private List<Recensione> recensioni=new ArrayList<>();
	
	private static long idGenUtente=1;
	private static long idGenFilm=1;
	private static long idGenSerie=1;
	private static long idGenRecensioni=1;
	
	
	/*public String registraUtente(String nome, String email ,String password, LocalDate data) {
		if (email==null||email.isEmpty())return "Inserisci una mail";
		Utente u=new Utente(nome, data, email, password,false,false);
		u.setId(idGenUtente++);
		utenti.add(u);
		return null;
	}
	*/
	public boolean loginUtente(String email ,String password) {
		
		if (email==null || email.isEmpty() || password==null || password.isEmpty()) {
			return false;
		}
		for(int i=0; i<utenti.size(); i++) {
			if (email.equals(utenti.get(i).getEmail()) && password.equals(utenti.get(i).getPassword())) {
				return true;
			}else {
				return false;
				
			}
		}
		return false;
	}
	
	public Utente getUtenteById(long id) {
		
		for(int i=0; i<utenti.size(); i++) {
			if(utenti.get(i).getId()==id) {
				return utenti.get(i);
			}
		}
		return null;
	}
	/*
	public boolean rendiAdmin(long id) {
		
		for(int i=0; i<utenti.size(); i++) {
			if (id==utenti.get(i).getId()) {
				if(!utenti.get(i).isAdmin()) {
					utenti.get(i).setAdmin(true);
					return true;
				}else {
					utenti.get(i).setAdmin(false);
					return false;
				}
			}
		}
	return false;
	}
	*/
	public boolean bloccaUtente(long id) {
		
		for(int i=0; i<utenti.size(); i++) {
			if (id==utenti.get(i).getId()) {
				if(!utenti.get(i).isBloccato()) {
					utenti.get(i).setBloccato(true);
					return true;
				}else {
					utenti.get(i).setBloccato(false);
					return false;
				}
			}
		}
	return false;
	}
	
	
	//---------------------FILM---------------------
	
	public String addFilm(String titolo, int durata, String genere) {

		if (titolo==null||titolo.isEmpty())return "Inserisci un titolo";
		Film f=new Film(titolo, durata, genere, false);
		f.setId(idGenFilm++);
		film.add(f);
		return null;
		
	}

	public List<Film> getListaFilm() {
		return film;
	}
	
	/*public List<String> getListaFilmTitolo() {
		List<String> r=new ArrayList<>();
		for (Film f : film) {
			r.add(f.getTitolo());
		}
		return r;
	}*/
	
	public boolean bloccaFilm(long id) {
		
		for(int i=0; i<film.size(); i++) {
			if (id==film.get(i).getId()) {
				if(!film.get(i).isBloccato()) {
					film.get(i).setBloccato(true);
					return true;
				}else {
					film.get(i).setBloccato(false);
					return false;
				}
			}
		}
	return false;
	}
	
	public Film getFilmById(long id) {
		
		for(int i=0; i<film.size(); i++) {
			if(film.get(i).getId()==id) {
				return film.get(i);
			}
		}
		return null;
	}
	
	//---------------------SERIE---------------------
	
	
	public String addSerie(String titolo, int n_episodi, String genere) {

		if (titolo==null||titolo.isEmpty())return "Inserisci un titolo";
		Serie s=new Serie(titolo, n_episodi, genere, false);
		s.setId(idGenSerie++);
		serie.add(s);
		return null;
		
	}

	public List<Serie> getListaSerie() {
		return serie;
	}
	
	public boolean bloccaSerie(long id) {
		
		for(int i=0; i<serie.size(); i++) {
			if (id==serie.get(i).getId()) {
				if(!serie.get(i).isBloccato()) {
					serie.get(i).setBloccato(true);
					return true;
				}else {
					serie.get(i).setBloccato(false);
					return false;
				}
			}
		}
	return false;
	}
	
	public Serie getSerieById(long id) {
		
		for(int i=0; i<serie.size(); i++) {
			if(serie.get(i).getId()==id) {
				return serie.get(i);
			}
		}
		return null;
	}
	
	
	
	
	//---------------------RECENSIONE---------------------

	
	public String addRecensioneFilm(int voto, String testo ,Utente u, Film f) {
		if (voto<=0 || voto >=6)return "Inserisci un voto tra 1 e 5";
		Recensione r=new Recensione(f, u, voto, testo);
		r.setId(idGenRecensioni++);
		u.getRecensioniUtente().add(r);
		//f.getVoti().add(r.getVoto());
		f.getRecensioniFilm().add(r);
		recensioni.add(r);
		return null;
	}
	
	public List<Recensione> getRecensioniByFilm(long id) {
		
		List<Recensione> r=new ArrayList<>(); 
		for(int i=0; i<recensioni.size(); i++) {
			if(recensioni.get(i).getFilm().getId()==id) {
				r.add(recensioni.get(i));
			}
		}
		return r;
	}
	
	public List<Recensione> getRecensioneByUtente(long id) {
		
		List<Recensione> r=new ArrayList<>(); 
		for(int i=0; i<recensioni.size(); i++) {
			if(recensioni.get(i).getUtente().getId()==id) {
				r.add(recensioni.get(i));
			}
		}
		return r;
	}
	
	public Recensione getRecensioneById(long id) {
		
		Recensione r=null;
		for(int i=0; i<recensioni.size(); i++) {
			if(recensioni.get(i).getId()==id) {
				r=recensioni.get(i);
			}
		}
		return r;
	}
	
	public Recensione aggiornaRecensioneFilm(long id, int voto, String testo) {
		
		for (Recensione r : recensioni) {
			if(r.getId()==id) {
				r.setTesto(testo);
				r.setVoto(voto);
				return r;
			}
		}
		return null;
	}
	
	
	
}











