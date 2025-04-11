package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.LoginDTO;
import com.example.demo.dto.request.RegistrazioneDTO;
import com.example.demo.dto.response.UtenteDTO;
import com.example.demo.model.Ruolo;
import com.example.demo.model.Utente;

@Component
public class UtenteMapper {

		public UtenteDTO toDto(Utente u) {
			UtenteDTO utenteDto=new UtenteDTO();
			utenteDto.setEmail(u.getEmail());
			utenteDto.setId(u.getId());
			return utenteDto;
		}
		
		public Utente toUtente(RegistrazioneDTO dto) {
			Utente u=new Utente(dto.getNome(), dto.getData(), dto.getEmail(), dto.getPassword(), false, Ruolo.UTENTE);
			return u;
		}
}
