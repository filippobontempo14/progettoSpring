package com.example.demo.model;

import java.util.Arrays;
import java.util.List;

public enum Stato {
	
	visto ("visto"),
	non_visto ("non_visto"),
	da_vedere ("da_vedere");
	
	private String descrizione;
	
	private Stato(String descrizione) {
		this.descrizione=descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public static List<Stato> listOf(){
		return Arrays.asList(Stato.values());
	}
	
	public static Stato parse(String stato) {

        return switch (stato.toLowerCase().trim()) {

	        case "visto" -> visto;
	        case "non_visto", "non visto" -> non_visto;
	        case "da_vedere", "da vedere"-> da_vedere;
	        default -> null;
        };
	}
}
