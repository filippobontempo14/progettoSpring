package com.example.demo.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class MessaggioErrore {
	
	private LocalDateTime timeStamp;
	private int status;
	private String messaggio,errore,path;
	
	public MessaggioErrore() {
		
	}

	public MessaggioErrore(int status, String messaggio, String errore, String path) {

		this.timeStamp = LocalDateTime.now();
		this.status = status;
		this.messaggio = messaggio;
		this.errore = errore;
		this.path = path;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public String getErrore() {
		return errore;
	}

	public void setErrore(String errore) {
		this.errore = errore;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
