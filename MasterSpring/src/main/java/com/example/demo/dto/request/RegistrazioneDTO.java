package com.example.demo.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegistrazioneDTO {
	
	@NotBlank(message = "Il nome non può essere vuoto")
    private String nome;
	private LocalDate data;
    @NotBlank(message = "L'email non può essere vuota")
    private String email;
    @NotBlank(message = "La password non può essere vuota")
    @Size(min = 1)
    private String password;

    public RegistrazioneDTO() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
