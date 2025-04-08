package com.example.demo.dto.response;

public class UtenteConEmailDTO {
	
	private String email;
	private long id;
	
	public UtenteConEmailDTO(String email, long id) {
		this.email = email;
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
