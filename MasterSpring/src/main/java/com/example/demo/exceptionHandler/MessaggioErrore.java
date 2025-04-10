package com.example.demo.exceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class MessaggioErrore {
	
	private LocalDateTime timeStamp;
	private int status;
	private String nomeStatus;
	private Map<String, String> errori;
	
	public MessaggioErrore() {
		
	}

	public MessaggioErrore(HttpStatus status, Map<String, String> errori) {

		this.timeStamp = LocalDateTime.now();
		this.status = status.value();
		this.nomeStatus=status.name();
		this.errori=errori;
		
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

	public Map<String, String> getErrori() {
		return errori;
	}

	public void setErrori(Map<String, String> errori) {
		this.errori = errori;
	}

	public String getNomeStatus() {
		return nomeStatus;
	}

	public void setNomeStatus(String nomeStatus) {
		this.nomeStatus = nomeStatus;
	}

	
	
	
	
	
}
